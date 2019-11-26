package com.hidm.newsmanage.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.entity.User;

@Service(value = "customRealm")
public class CustomRealm extends AuthorizingRealm {
    
    // 设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // token中包含用户输入的用户名和密码
        // 第一步从token中取出用户名
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String employeeNo = upToken.getUsername();
        String password = new String(upToken.getPassword());
        
        User user = new User();
        user.setEmployeeNo(employeeNo);
        
        /*List<User> users = null;
        users = userService.selectUser(user);
        if (CollectionUtils.isNotEmpty(users)) {
            log.info("登陆成功！ userName:" + userName);
            *//**
             * 认证的用户,正确的密码
             *//*
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(users.get(0), password, this.getName());
            return authcInfo;
        } else {
            throw new AccountException("帐号或密码不正确！");
        }*/
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, password, this.getName());
        return authcInfo;
    }

    /**
     * 授权,只有成功通过<span style="font-family: Arial, Helvetica,
     * sans-serif;">doGetAuthenticationInfo方法的认证后才会执行。</span>
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 从 principals获取主身份信息
        // 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
        User user = (User) principals.getPrimaryPrincipal();

        if (user == null) {
            return null;
        }
        
       
        // 查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        return simpleAuthorizationInfo;
    }
}
