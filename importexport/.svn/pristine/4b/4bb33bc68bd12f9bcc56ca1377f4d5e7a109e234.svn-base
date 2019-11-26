package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ImportItemHis;
import com.hidm.importexport.vo.ImportItemHisSearchVo;
import com.hidm.importexport.vo.ImportItemHisVo;

/**
 * 
*Description: 处理importItem的日志记录数据
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ImportItemHisService {
	/**
	 * 
	*Description: 新增日志记录
	*@param importItemHis
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ImportItemHis importItemHis);

    /**
     * 
    *Description: 根据id查询日志记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportItemHisVo> selectByItemId(ImportItemHisSearchVo vo);

    /**
     * 
    *Description: 查询根据id获取记录的数量
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int countByItemId(ImportItemHisSearchVo vo);
}

