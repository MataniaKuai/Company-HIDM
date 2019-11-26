package com.hidm.coo.util;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.hidm.coo.constant.LoginConstant;
import com.hidm.coo.entity.User;

public class LoginUtil {

    public static boolean checkLogin(HttpSession session) {
        Object obj = session.getAttribute(LoginConstant.CURRENT_USER_NAME);
        return null != obj;
    }
    
    public static User getUserInfo() {
        User user = null;
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            user = (User) principal;
        }
        return user;
    }
}
