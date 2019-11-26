package com.hidm.sso.service;

import java.util.List;

import com.hidm.sso.entity.UserInfo;

public interface UserInfoService {
    List<UserInfo> selectUser(String userName);

    public void updateById(UserInfo userInfo);

    List<UserInfo> selectUserByUsePwd(UserInfo userInfo);
}
