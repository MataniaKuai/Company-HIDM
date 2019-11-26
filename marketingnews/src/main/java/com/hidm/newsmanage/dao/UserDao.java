package com.hidm.newsmanage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.newsmanage.entity.User;

@Mapper
public interface UserDao {
    public int checkUser(User user);
    public User selectName(User user);
}
