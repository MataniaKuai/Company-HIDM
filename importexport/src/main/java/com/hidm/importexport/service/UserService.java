package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.User;
import com.hidm.importexport.vo.PortalDeptVo;
import com.hidm.importexport.vo.PortalUserVo;

/**
 * 
*Description: 处理用户信息数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface UserService {
	/**
	 * 
	*Description: 新增记录
	*@param user
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public int insert(User user);
    
    /**
     * 
    *Description: 根据id查询记录
    *@param user  
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void updateById(User user);
    
    /**
     * 
    *Description: 验证用户信息
    *@param user
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public boolean checkUser(User user);
    
    /**
     * 
    *Description: 查询所有用户记录
    *@param user
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<User> selectUser(User user);
    
    /**
     * 
    *Description: 根据用户名获取用户信息
    *@param employeeNo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public PortalUserVo getUserInfoByEmployeeNo(String employeeNo);
}
