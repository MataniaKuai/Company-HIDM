package com.hidm.booksharingscore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.vo.UserSearchVo;


@Mapper
public interface UserDao {
    public List<User> selectList(UserSearchVo vo);
    
    public List<User> selectUser(User user);

	public int count(UserSearchVo vo);

	public void insert(User user);

	public void updateById(User user);

	public void deleteByIds(Long[] ids);

	public List<User> selectUserByIdList(List<Long> userIdList);

	public List<User> selectUserByEmployeeNoList(List<String> signinList);
}
