package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.vo.BusinessHisSearchVo;

/**
 * 
*Description: 处理进口数据、保税主档数据、item数据操作日志信息
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface BusinessHisService {
	/**
	 * 
	*Description: 日志信息记录的插入
	*@param businessId 插入对象的主键
	*@param businessNo 插入对象的编号
	*@param businessType  插入对象类型（进口数据、原材料、资产、item）
	*@param action 插入对象被执行的动作（新增、更新、删除）
	*@param object json对象
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public void insert(String businessId, String businessNo, int businessType, int action, Object object);
    
    /**
     * 
    *Description: 日志信息记录的数量查询
    *@param businessHis
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(BusinessHisSearchVo businessHis);
    
    /**
     * 
    *Description: 日志信息记录的查询
    *@param businessHis
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<BusinessHisSearchVo> selectList(BusinessHisSearchVo businessHis);
    
}
