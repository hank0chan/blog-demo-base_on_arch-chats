package cn.hankchan.webchats.api.article;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hankchan.article.service.ArticleDataServiceImpl;
import cn.hankchan.data.article.entity.Article;
import cn.hankchan.webchats.api.result.APIResult;
import cn.hankchan.webchats.util.TimeUtils;

@Controller
public class ArticleAPIs {

	@Autowired
	ArticleDataServiceImpl articleDataService;
	
	@RequestMapping("/article/delete-{articleId}.json")
	public @ResponseBody APIResult deleteById(HttpServletRequest req, HttpServletResponse rsp, 
			@PathVariable("articleId") String articleId) {
		APIResult result = APIResult.prepare();
		HttpSession session = req.getSession();
		if(session.getAttribute("root") != null) {
			// TODO 校验通过
			int isSuccess = articleDataService.delete(articleId);
			return isSuccess > 0 ? result.ok("delete Success") : result.error("failure..");
		} else {
			// 校验失败
			return result.error("error..refused to aceess!");
		}
	}
	
	/**
	 * 获取指定年月YYYYMM的文章信息（articleId,name,updateTime）
	 * @return Articles's id, name, updateTime
	 */
	@RequestMapping("/article/gets-yyyymm={yyyyMM}.json")
	public @ResponseBody APIResult getNamesByYYYYMM(HttpServletRequest req, HttpServletResponse rsp, 
			@PathVariable("yyyyMM") String yyyyMM) {
		APIResult result = APIResult.prepare();
		List<Article> articles = articleDataService.getNamesByYYYYMM(yyyyMM);
		return articles != null ? result.ok(articles) : result.error("failure..");
	}
	
	/**
	 * 保存文章
	 * @return Save == success ? return articleId : return "failure msg"
	 */
	@RequestMapping(value="/article/publish.json",method=RequestMethod.POST)
	public @ResponseBody APIResult publishArticle(HttpServletRequest req, HttpServletResponse rsp,
			@RequestParam("name") String articleName, 
			@RequestParam("content") String articleContent, 
			@RequestParam(value="tips",required=false) String tips) {
		APIResult result = APIResult.prepare();
		HttpSession session = req.getSession();
		if(session.getAttribute("root") != null) {
			// TODO 校验通过
			Article article = new Article();
			article.setArticleId(TimeUtils.YYYYMMDDHHMMSSFFF.format(new Date()));
			article.setName(articleName);
			article.setContent(articleContent);
			article.setUpdateTime(TimeUtils.YYYYMMDDHHMM.format(new Date()));
			article.setTips((tips == null ? "null" : tips));
			Article isSuccess = articleDataService.insert(article);
			return isSuccess != null ? result.ok(isSuccess.articleId) : result.error("failure..");	
		} else {
			return result.error("error..refused to access!");
		}
		
	}
	
	@RequestMapping("/article/get-id={articleId}.json")
	public @ResponseBody APIResult getArticle(HttpServletRequest req, HttpServletResponse rsp, 
			@PathVariable("articleId") String articleId) {
		APIResult result = APIResult.prepare();
		Article article = articleDataService.getAritcle("articleId");
		return article != null ? result.ok(article) : result.error("failure..");
	}
	
	/** 根据创建时间获取文章 */
	@RequestMapping("/article/get-time={createTime}.json")
	public @ResponseBody APIResult getArticleByTime(HttpServletRequest req, HttpServletResponse rsp, 
			@PathVariable("createTime") String createTime) {
		APIResult result = APIResult.prepare();
		Article article = articleDataService.getArticleByTime(createTime);
		return article != null ? result.ok(article) : result.error("failure..");
	}
	
	// 测试
	@RequestMapping("/article.json")
	public @ResponseBody APIResult getArticle0(HttpServletRequest req, HttpServletResponse rsp) {
		APIResult result = APIResult.prepare();
		Article article = articleDataService.getAritcle("100");
		return article != null ? result.ok(article) : result.error("failure..");
	}
	
}
