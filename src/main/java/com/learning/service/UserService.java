package com.learning.service;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.dao.UserMapper;
import com.learning.model.User;


@Service("userService")  
public class UserService implements IUserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserMapper userDAO;
	
	public int deleteByPrimaryKey(Integer userId) {
		return this.userDAO.deleteByPrimaryKey(userId);
	}

	public int insert(User user) {

        return this.userDAO.insert(user);
	}

	public User selectByPrimaryKey(Integer userId) {
		return this.userDAO.selectByPrimaryKey(userId);
	}


	public int updateByPrimaryKey(User user) {
		return this.userDAO.updateByPrimaryKey(user);
	}

}
