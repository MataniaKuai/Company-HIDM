package com.hidm.booksharingscore.service;

import java.util.List;

import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.vo.UserSearchVo;

public interface UserService {
	
    public List<User> selectList(UserSearchVo vo);
    
    public List<User> selectUser(User user);

	public int count(UserSearchVo vo);

	public void insert(User user);

	public void updateById(User user);

	public void deleteByIds(Long[] ids);

	public List<User> selectUserByIdList(List<Long> userIdList);

	public List<User> selectUserByEmployeeNoList(List<String> signinList);
    
}