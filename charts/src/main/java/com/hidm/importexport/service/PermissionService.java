package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.Permission;

/**
 * 
*Description: 处理用户权限认证
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface PermissionService {
	/**
	 * 
	*Description: 查询所有权限
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public List<Permission> selectAll();

    /**
     * 根据角色查询所有权限
     * @param id
     */
    public List<Permission> selectListByRole(Long id);
}
