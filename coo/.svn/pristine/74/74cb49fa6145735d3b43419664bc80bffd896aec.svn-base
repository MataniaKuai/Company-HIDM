package com.hidm.coo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.UserDao;
import com.hidm.coo.entity.User;
import com.hidm.coo.service.UserService;
import com.hidm.coo.util.RestUtil;
import com.hidm.coo.vo.PortalUserVo;
import com.hidm.coo.vo.UserSearchVo;
import com.hidm.coo.vo.UserVo;

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
    
    public User selectUser(User user) {
        User users = userDao.selectUser(user);
        return users;
    }
    
    public PortalUserVo getUserInfoByEmployeeNo(String employeeNo) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("userid", employeeNo);
        PortalUserVo PortalUserVo = RestUtil.post(getUserNameURL, param, PortalUserVo.class);
        return PortalUserVo;
    }
    
    @Override
    public int count(UserSearchVo user) {
        return userDao.count(user);
    }

    @Override
    public List<UserVo> selectList(UserSearchVo user) {
        return userDao.selectList(user);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        userDao.deleteByIds(ids);
    }

    @Override
    public List<UserVo> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<UserVo> selectInfoByIds(Long[] ids) {
        return userDao.selectInfoByIds(ids);
    }

	@Override
	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
