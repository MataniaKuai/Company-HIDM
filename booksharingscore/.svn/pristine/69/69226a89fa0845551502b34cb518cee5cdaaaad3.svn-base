package com.hidm.booksharingscore.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.hidm.booksharingscore.entity.User;

public class LoginUtil {
    
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
