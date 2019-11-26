package com.hidm.sso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.sso.entity.UserInfo;

@Mapper
public interface UserInfoDao {

    List<UserInfo> selectUser(String userName);

    void updateById(UserInfo userInfo);

    List<UserInfo> selectUserByUsePwd(UserInfo userInfo);
    
}
