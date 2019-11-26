package com.hidm.coo.service;

import java.util.ArrayList;
import java.util.List;

import com.hidm.coo.entity.MaterialsCostItem;
import com.hidm.coo.vo.MaterialsCostItemSearchVo;
import com.hidm.coo.vo.MaterialsCostItemVo;

/**
 * 
*Description: 获取EQtype
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface MaterialsCostItemService {
    
    /**
     * 
    *Description: 新增数据
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int insert(MaterialsCostItem materialsCostItem);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(MaterialsCostItem materialsCostItem);
    
    /**
     * 
    *Description: 查询记录数量
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(MaterialsCostItemSearchVo materialsCostItemSearchVo);
    
    /**
     * 
    *Description: 查询记录列表
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MaterialsCostItemVo> selectList(MaterialsCostItemSearchVo materialsCostItemSearchVo);
    
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
    *Description: 根据userBaseId删除记录
    *@param 
    *@return 
    *@author kmd
    *@date 2019.6.26
    *@version 1.0
     */
    public void deleteByUserBaseIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param EQtype
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MaterialsCostItemVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MaterialsCostItemVo> selectInfoByIds(Long[] ids);
    
    public List<MaterialsCostItemVo> searchInfo(MaterialsCostItemVo materialsCostItemVo);

	public ArrayList<MaterialsCostItemVo> selectByUserBaseId(Long userBaseId);
}
