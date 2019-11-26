package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.OPBase;
import com.hidm.coo.vo.OPBaseSearchVo;
import com.hidm.coo.vo.OPBaseVo;

/**
 * 
*Description: 处理OPBase基本数据
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface OPBaseService {
	
	/**
	 * 
	*Description: 新增数据
	*@param OPBase
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public int insert(OPBase opBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(OPBase opBase);
    
    /**
     * 
    *Description: 查询记录数量
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(OPBaseSearchVo opBaseVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<OPBaseVo> selectList(OPBaseSearchVo opBaseVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<OPBaseVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    
    /**
     * 
    *Description: 根据UserBaseId删除记录
    *@param PROBase
    *@return 
    *@author kmd
    *@date 2019.6.20
    *@version 1.0
     */
    public void deleteByUserBaseIds(Long[] ids);
    
    public List<OPBaseVo> selectInfoByIds(Long[] ids);
    
    
    public OPBase synchToSap(OPBase opBase);

    public List<OPBase> selectByUserId(Long id);

}
