package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.UserBase;
import com.hidm.coo.vo.UserBaseSearchVo;
import com.hidm.coo.vo.UserBaseVo;

/**
 * 
*Description: 处理用户基本数据
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface UserBaseService {
	
	/**
	 * 
	*Description: 新增数据
	*@param userBase
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public int insert(UserBase userBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param userBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(UserBase userBase);
    
    /**
     * 
    *Description: 查询记录数量
    *@param userBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(UserBaseSearchVo userBase);
    
    /**
     * 
    *Description: 查询记录列表
    *@param userBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UserBaseVo> selectList(UserBaseSearchVo userBase);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param userBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param userBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UserBaseVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UserBaseVo> selectInfoByIds(Long[] ids);
    
    
    /**
     * 
     * @param userBase
     * @return
     * @author guorong
     * @date 2019.6.26
     * @version 1.0
     */
    public UserBase synchToSap(UserBase userBase);

    public List<UserBaseVo> selectCheckData(UserBaseSearchVo vo);

    /**
     * 
     * @param userBase
     * @return	计算ex_mlCost
     * @author kmd
     * @date 2019.7.3
     * @version 1.0
     */
    public UserBase synchToSap2(UserBase userBase);

    public int countMc(UserBaseSearchVo vo);

    public List<UserBaseVo> selectListMc(UserBaseSearchVo vo);
}
