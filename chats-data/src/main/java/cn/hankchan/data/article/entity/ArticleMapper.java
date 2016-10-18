package cn.hankchan.data.article.entity;

public interface ArticleMapper {

	public Article getArticleByTime(String createTime);
	
	public Article get(String articleId);
	
}
