package cn.hankchan.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hankchan.article.service.ArticleDataServiceImpl;
import cn.hankchan.data.article.entity.Article;

public class TestArticleService {

	static ArticleDataServiceImpl dataService;
	static ApplicationContext xml;
	@BeforeClass
	public static void init() {
		xml = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		dataService = (ArticleDataServiceImpl) xml.getBean("articleDataService");
	}
	@AfterClass
	public static void destory() { }
	
	@Test
	public void getNamesByYYYYMM() {
		List<Article> atArticles = dataService.getNamesByYYYYMM("201610");
		for (Article article : atArticles) {
			System.out.println(article);			
		}
	}
	
	@Test
	public void testDelete() {
		int result = dataService.delete("201211");
		System.out.println(result);
	}
	
	@Test
	public void testInsert() {
		Article article = new Article();
		article.setArticleId("201211");
		article.setName("testTitle");
		article.setContent("Text");
		article.setCreateTime("201210");
		article.setUpdateTime("201210");
		article.setTips("null");
		Article result = dataService.insert(article);
		System.out.println(result);
	}
	
	@Test
	public void testFuzzyQueryByTime() {
		List<Article> articles = dataService.fuzzyQueryByTime("201610");
		if(articles != null) {
			System.out.println(articles.size());
			System.out.println(articles.get(0));
		} else {
			System.out.println("null");
		}
	}
	
	@Test
	public void testGetArticleByTime() {
		Article article = dataService.getArticleByTime("201610162300");
		System.out.println(article);
	}
	
	@Test
	public void testGetAritcle() {
		Article article = dataService.getAritcle("100");
		System.out.println(article);
	}
	
}
