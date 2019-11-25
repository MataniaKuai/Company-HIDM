package com.hidm.importexport.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.UserDao;
import com.hidm.importexport.entity.User;
import com.hidm.importexport.service.UserService;
import com.hidm.importexport.util.RestUtil;
import com.hidm.importexport.vo.PortalUserVo;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Value("${getUserNameURL}")
    private String getUserNameURL;
    
    public int insert(User user) {
        return userDao.insert(user);
    }
    
    public void updateById(User user) {
        user.setUpdateTime(new Date());
        userDao.updateById(user);
    }
    
    public boolean checkUser(User user) {
        int count = userDao.checkUser(user);
        return count > 0;
    }
    
    public List<User> selectUser(User user) {
        List<User> users = userDao.selectUser(user);
        return users;
    }
    
    public PortalUserVo getUserInfoByEmployeeNo(String employeeNo) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userid", employeeNo);
        PortalUserVo PortalUserVo = RestUtil.post(getUserNameURL, param, PortalUserVo.class);
        return PortalUserVo;
    }
}
