package com.two.dao;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.two.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserMapperTest {
	private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userDAO;

	@Test
	public void insert() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("James");
        user.setUserSalary(15000.0);
        this.userDAO.insert(user);
        
        
        logger.info("insert the user={}",user);
        this.userDAO.deleteByPrimaryKey(user.getUserId());
        
        User u = this.userDAO.selectByPrimaryKey(user.getUserId());
        logger.info("after delete the user={}", u);
	}

	@Test
	public void selectByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("James");
        user.setUserSalary(15000.0);
        this.userDAO.insert(user);
        
        User u = this.userDAO.selectByPrimaryKey(user.getUserId());
        logger.info("after delete the user={}", u);
        
        this.userDAO.deleteByPrimaryKey(u.getUserId());
	}

	@Test
	public void updateByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("Daniel");
        user.setUserSalary(13000.0);
        logger.info("before update the user={}", user);
        this.userDAO.insert(user);

        user.setUserSalary(22000.0);
        this.userDAO.updateByPrimaryKey(user);

        User u = this.userDAO.selectByPrimaryKey(user.getUserId());
        logger.info("after update the user={}", u);

        this.userDAO.deleteByPrimaryKey(u.getUserId());
	}

}
