package cn.hankchan.article.service;

import java.util.List;

import cn.hankchan.article.ArticleDataService;
import cn.hankchan.dao.mybatis.DataRepository;
import cn.hankchan.data.article.entity.Article;
import cn.hankchan.webchats.lang.Criteria;

public class ArticleDataServiceImpl implements ArticleDataService {

	DataRepository dataRepository;
	public void setDataRepository(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	public int delete(String articleId) {
		return dataRepository.delete(Article.class, new Criteria().with("articleId", articleId));
	}
	@Override
	public List<Article> getNamesByYYYYMM(String yyyyMM) {
		return dataRepository.query("getNamesByYYYYMM", Article.class, yyyyMM);
	}
	
	@Override
	public List<Article> fuzzyQueryByTime(String createTime) {
		return dataRepository.query("fuzzyQueryByTime", Article.class, new Criteria().with("createTime", createTime));
	}
	
	@Override
	public Article getAritcle(String id) {
		return dataRepository.get("get", Article.class, id);
	}

	@Override
	public Article getArticleByTime(String createTime) {
		return dataRepository.get("getArticleByTime", Article.class, createTime);
	}

	@Override
	public Article insert(Article article) {
		return dataRepository.create(article);
	}

}
