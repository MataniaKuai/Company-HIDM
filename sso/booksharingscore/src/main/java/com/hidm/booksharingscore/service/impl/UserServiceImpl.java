package com.hidm.booksharingscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.booksharingscore.dao.UserDao;
import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.UserService;
import com.hidm.booksharingscore.vo.UserSearchVo;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    public List<User> selectList(UserSearchVo vo) {
        List<User> users = userDao.selectList(vo);
        return users;
    }

	public int count(UserSearchVo vo) {
		// TODO Auto-generated method stub
		return userDao.count(vo);
	}
	
	public List<User> selectUser(User user) {
        List<User> users = userDao.selectUser(user);
        return users;
    }

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public void updateById(User user) {
		userDao.updateById(user);
		
	}

	@Override
	public void deleteByIds(Long[] ids) {
		userDao.deleteByIds(ids);		
	}

	@Override
	public List<User> selectUserByIdList(List<Long> userIdList) {
		return userDao.selectUserByIdList(userIdList);	
	}

	@Override
	public List<User> selectUserByEmployeeNoList(List<String> signinList) {
		return userDao.selectUserByEmployeeNoList(signinList);
	}
}
