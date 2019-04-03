package com.learning.service;

import javax.annotation.Resource;  

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.service.IUserService;
import com.learning.model.User;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration({"classpath:spring-mybatis.xml"})  
public class UserServiceTest {
	private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	private IUserService userService;  
	
	/*
	 * private ApplicationContext ac = null;
	 * 
	 * @Before public void before() { ac = new
	 * ClassPathXmlApplicationContext("applicationContext.xml"); userService =
	 * (IUserService) ac.getBean("userService"); }
	 */
	
	@Test
	public void testDeleteByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("James");
        user.setUserSalary(15000.0);
        this.userService.insert(user);
        
        logger.info("insert the user={}",user);
        this.userService.deleteByPrimaryKey(user.getUserId());
	}

	@Test
	public void testInsert() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("James");
        user.setUserSalary(15000.0);
        this.userService.insert(user);
        
        logger.info("insert the user={}",user);
        this.userService.deleteByPrimaryKey(user.getUserId());
        
        User u = this.userService.selectByPrimaryKey(user.getUserId());
        logger.info("after delete the user={}", u);
	}

	@Test
	public void testSelectByPrimaryKey() {
        int id = 1;
        User u = this.userService.selectByPrimaryKey(id);
        logger.info("after get the user={}", u);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("Daniel");
        user.setUserSalary(13000.0);
        logger.info("before update the user={}", user);
        this.userService.insert(user);

        user.setUserSalary(22000.0);
        this.userService.updateByPrimaryKey(user);
        
        int id = user.getUserId();
        User u = this.userService.selectByPrimaryKey(id);
        logger.info("after update the user={}", u);

        this.userService.deleteByPrimaryKey(id);
	}

}
