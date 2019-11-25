package com.hidm.importexport.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hidm.importexport.entity.Role;

/**
 * 
*Description: 处理用户角色数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface RoleService {
	
	/**
	 * 
	*Description: 根据用户名查询对应角色信息
	*@param userName
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public List<Role> selectRoleByUserName(String userName);
    
    /**
     * 
    *Description: 根据访问路径url查询用户角色
    *@param url
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<Role> selectRoleByUrl(@Param("url")String url);
}