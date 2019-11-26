package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.InOut;
import com.hidm.importexport.vo.InOutSearchVo;
import com.hidm.importexport.vo.InOutVo;

/**
 * 
*Description: 处理进出口数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface InOutService {
	
	/**
	 * 
	*Description: 新增进口数据
	*@param inout
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public int insert(InOut inout);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param inout 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void updateById(InOut inout);
    
    /**
     * 
    *Description: 查询记录数量
    *@param inout 
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public int count(InOutSearchVo inout);
    
    /**
     * 
    *Description: 查询数据列表
    *@param inout
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<InOutVo> selectList(InOutSearchVo inout);
    
    /**
     * 
    *Description: 查询报表列表记录
    *@param inout
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<InOutVo> selectExport(InOutSearchVo inout);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
}
