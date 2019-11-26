package com.hidm.coo.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.RoleDao;
import com.hidm.coo.entity.Role;
import com.hidm.coo.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    
    public List<Role> selectRoleByUserName(String userName) {
        List<Role> roles = roleDao.selectRoleByUserName(userName);
        return roles;
    }
    
    public List<Role> selectRoleByUrl(@Param("url")String url) {
        List<Role> roles = roleDao.selectRoleByUrl(url);
        return roles;
    }
}
