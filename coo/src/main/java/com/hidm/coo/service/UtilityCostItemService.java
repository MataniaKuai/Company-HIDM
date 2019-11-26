package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.UtilityCostItem;
import com.hidm.coo.vo.UtilityCostItemSearchVo;
import com.hidm.coo.vo.UtilityCostItemVo;

/**
 * 
*Description: 获取EQtype
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface UtilityCostItemService {
    
    /**
     * 
    *Description: 新增数据
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int insert(UtilityCostItem utilityCostItem);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(UtilityCostItem utilityCostItem);
    
    /**
     * 
    *Description: 查询记录数量
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(UtilityCostItemSearchVo utilityCostItemSearchVo);
    
    /**
     * 
    *Description: 查询记录列表
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UtilityCostItemVo> selectList(UtilityCostItemSearchVo utilityCostItemSearchVo);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    
    /**
     * 
    *Description: 根据userBaseId删除记录
    *@param 
    *@return 
    *@author kmd
    *@date 2019.6.26
    *@version 1.0
     */
    public void deleteByUserBaseIds(Long[] ids);
    
    public List<UtilityCostItemVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UtilityCostItemVo> selectInfoByIds(Long[] ids);
    
    public List<UtilityCostItemVo> searchInfo(UtilityCostItemVo utilityCostItemVo);

	public List<UtilityCostItemVo> selectInfo(UtilityCostItemVo utilityCostItemVo);
    
    
    
}
