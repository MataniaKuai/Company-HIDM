package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.coo.entity.Role;

@Mapper
public interface RoleDao {
    public List<Role> selectRoleByUserName(@Param("userName")String userName);
    
    public List<Role> selectRoleByUrl(@Param("url")String url);
}
