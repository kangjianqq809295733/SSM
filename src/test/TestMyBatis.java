package test;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.User;
import service.UserService;

import com.alibaba.fastjson.JSON;

import dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	//@Resource
	private UserService userService = null;
	private ApplicationContext ac = null;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("classpath:spring-mvc.xml","classpath:spring-mybatis.xml");
		userService = (UserService) ac.getBean("userService");
		System.out.println("初始化");
	}

	@Test
	public void test1() throws Exception {
		User user = userService.getUserById(1);
		System.out.println(user.getUser_name());
		logger.info(JSON.toJSONString(user));
	}
}