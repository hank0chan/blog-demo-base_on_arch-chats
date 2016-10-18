package cn.hankchan.article;

import java.util.List;

import cn.hankchan.data.article.entity.Article;

public interface ArticleDataService {
	
	public List<Article> getNamesByYYYYMM(String yyyyMM);
	
	public Article getAritcle(String id);
	
	public Article getArticleByTime(String createTime);
	
	public List<Article> fuzzyQueryByTime(String createTime);
	
	public Article insert(Article article);
}
