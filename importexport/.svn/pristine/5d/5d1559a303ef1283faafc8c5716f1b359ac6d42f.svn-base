package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ImportBatchHis;
import com.hidm.importexport.vo.ImportBatchHisSearchVo;
import com.hidm.importexport.vo.ImportBatchHisVo;

/**
 * 
*Description: 处理批次日志记录
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ImportBatchHisService {
	
	/**
	 * 
	*Description: 新增批次操作记录信息
	*@param importBatchHis
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ImportBatchHis importBatchHis);

    /**
     * 
    *Description: 根据itemId查询批次日志记录信息
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportBatchHisVo> selectByItemHisId(ImportBatchHisSearchVo vo);
}
