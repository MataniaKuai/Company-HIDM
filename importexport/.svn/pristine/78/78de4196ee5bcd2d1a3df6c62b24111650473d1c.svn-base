package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.PermissionDao;
import com.hidm.importexport.entity.Permission;
import com.hidm.importexport.service.PermissionService;

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
