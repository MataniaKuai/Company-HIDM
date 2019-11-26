package com.hidm.sso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.sso.dao.UserInfoDao;
import com.hidm.sso.entity.UserInfo;
import com.hidm.sso.service.UserInfoService;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired  
    private UserInfoDao userInfoDao;
    @Override
    public List<UserInfo> selectUser(String userName) {
        return userInfoDao.selectUser(userName);
    }
    @Override
    public void updateById(UserInfo userInfo) {
        userInfoDao.updateById(userInfo);
    }
    @Override
    public List<UserInfo> selectUserByUsePwd(UserInfo userInfo) {
        return userInfoDao.selectUserByUsePwd(userInfo);
    }  

}
