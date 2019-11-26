package com.hidm.newsmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.dao.UserDao;
import com.hidm.newsmanage.entity.User;
import com.hidm.newsmanage.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDao userDao;

	public boolean checkUser(User user) {
    	int count = userDao.checkUser(user);
    	return count > 0;
    }
	
	public User selectName(User user) {
    	return userDao.selectName(user);
    }
}
