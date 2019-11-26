package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.Department;
import com.hidm.importexport.vo.DepartmentSearchVo;

/**
 * 
*Description: 处理部门数据
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface DepartmentService {
	
	/**
	 * 
	*Description: 插入部门记录
	*@param department
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(Department department);
    
    /**
     * 
    *Description: 根据id更新部门信息
    *@param department 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void updateById(Department department);
    
    /**
     * 
    *Description: 查询记录数量
    *@param department
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(DepartmentSearchVo department);
    
    /**
     * 
    *Description: 查询记录数据列表
    *@param department
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<Department> selectList(DepartmentSearchVo department);
    
    /**
     * 
    *Description: 查询中心列表
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<Department> listCenter();
    
    /**
     * 
    *Description: 根据id删除部门记录
    *@param ids 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
}
