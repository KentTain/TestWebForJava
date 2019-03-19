package com.learning.dao;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learning.dao.UserMapper;
import com.learning.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserMapperTest {

	private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    public UserMapper userDAO;

	@Test
	public void TestInsert() {
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
	public void TestSelectByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("James");
        user.setUserSalary(15000.0);
        this.userDAO.insert(user);
        
        int id = user.getUserId();
        
        User u = this.userDAO.selectByPrimaryKey(id);
        logger.info("after delete the user={}", u);

        this.userDAO.deleteByPrimaryKey(id);
	}

	@Test
	public void TestUpdateByPrimaryKey() {
		User user = new User();
        user.setUserBirthday(new Date());
        user.setUserName("Daniel");
        user.setUserSalary(13000.0);
        logger.info("before update the user={}", user);
        this.userDAO.insert(user);

        user.setUserSalary(22000.0);
        this.userDAO.updateByPrimaryKey(user);
        
        int id = user.getUserId();
        User u = this.userDAO.selectByPrimaryKey(id);
        logger.info("after update the user={}", u);

        this.userDAO.deleteByPrimaryKey(id);
	}

}
