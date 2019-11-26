package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.PermissionDao;
import com.hidm.coo.entity.Permission;
import com.hidm.coo.service.PermissionService;

@Service(value = "permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    
    public List<Permission> selectAll() {
        List<Permission> permissions = permissionDao.selectAll();
        return permissions;
    }

    @Override
    public List<Permission> selectListByRole(Long id) {
        List<Permission> permissions = permissionDao.selectListByRole(id);
        return permissions;
    }
}
