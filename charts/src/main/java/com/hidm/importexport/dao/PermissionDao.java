package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.importexport.entity.Permission;

@Mapper
public interface PermissionDao {
    public List<Permission> selectAll();

    public List<Permission> selectListByRole(@Param(value="roleId") Long id);
}
