package com.hidm.importexport.service;

import com.hidm.importexport.entity.IrNo;

import java.util.List;

/**
 * 
*Description: 处理irNo数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface IrNoService {
	/**
	 * 
	*Description: 新增irNo记录
	*@param irNo
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public int insert(IrNo irNo);
    
    /**
     * 
    *Description: 根据id更新irNo
    *@param irNo 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void updateById(IrNo irNo);
    
    /**
     * 
    *Description: 查询irNo记录
    *@param irNo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<IrNo> selectList(IrNo irNo);
    
    /**
     * 
    *Description: 查询irNo记录
    *@param irNo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<IrNo> selectForUpate(IrNo irNo);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
    
    /**
     * 
    *Description: 根据年份删除记录
    *@param years 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void deleteByYears(Long[] years);
    
    /**
     * 
    *Description: 新增记录
    *@param year
    *@param org
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public int generateSeqNo(int year, String org);
}
