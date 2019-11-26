package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ReleaseHis;
import com.hidm.importexport.vo.ReleaseHisSearchVo;
import com.hidm.importexport.vo.ReleaseHisVo;

/**
 * 
*Description: 处理release操作日志
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface ReleaseHisService {

	/**
	 * 
	*Description: 新增记录
	*@param releaseHis 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    void insert(ReleaseHis releaseHis);
    
    /**
     * 
    *Description: 查询记录数量
    *@param releaseHis 
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    int count(ReleaseHisSearchVo releaseHis);
    
    /**
     * 
    *Description: 查询报表记录列表
    *@param releaseHis
    *@return 
    *@author MeiDong
    *@date 2018年12月24日
    *@version 1.0
     */
    public List<ReleaseHisVo> selectReportList(ReleaseHisSearchVo releaseHis);
    
    /**
     * 
    *Description: 导出记录列表
    *@param release
    *@return 
    *@author MeiDong
    *@date 2018年12月24日
    *@version 1.0
     */
    public List<ReleaseHisVo> selectExport(ReleaseHisSearchVo release);

}
