package cn.hankchan.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hankchan.data.root.entity.Root;
import cn.hankchan.root.service.RootDataServiceImpl;

public class TestRootService {

	static ApplicationContext xml;
	static RootDataServiceImpl dataServiceImpl;
	@BeforeClass
	public void init() {
		xml = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		dataServiceImpl = (RootDataServiceImpl) xml.getBean("rootDataService");
	}
	@AfterClass
	public void destory() { }
	
	@Test
	public void testDelete() {
		int result = dataServiceImpl.delete("user", "user");
		System.out.println(result);
	}
	
	@Test
	public void testUpdate() {
		Root root = new Root();
		root.setRoot("user");
		root.setPassword("user");
		root.setPhone("13415157551");
		Root result = dataServiceImpl.update(root);
		System.out.println(result);
	}
	
	@Test
	public void testCount() {
		Root root = dataServiceImpl.count("root", "root", "15920121585");
		System.out.println(root);
	}
	
	@Test
	public void testGet() {
		Root root = dataServiceImpl.get("root");
		System.out.println(root);
	}
}
