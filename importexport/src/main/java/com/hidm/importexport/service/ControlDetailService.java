package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ControlDetail;
import com.hidm.importexport.vo.ControlDetailSearchVo;
import com.hidm.importexport.vo.ControlDetailVo;

/**
 * 
*Description: 处理监管明细数据
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ControlDetailService {
	
	/**
	 * 
	*Description: 监管明细信息的新增
	*@param controlDetail
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ControlDetail controlDetail);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param controlDetail 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void updateById(ControlDetail controlDetail);
    
    /**
     * 
    *Description: 查询记录的数量
    *@param controlDetail
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(ControlDetailSearchVo controlDetail);
    
    /**
     * 
    *Description: 查询记录列表
    *@param controlDetail
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ControlDetailVo> selectList(ControlDetailSearchVo controlDetail);
    
    /**
     * 
    *Description: 查询报表记录列表
    *@param controlDetail
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ControlDetailVo> selectExport(ControlDetailSearchVo controlDetail);
    
    /**
     * 
    *Description: 根据id删除记录信息
    *@param ids 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询报表列表记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ControlDetailVo> selectReportList(ControlDetailSearchVo vo);

    /**
     * 
    *Description: 报表查询记录数量
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int countReportList(ControlDetailSearchVo vo);

    /**
     * 
    *Description: 报表查询记录列表
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ControlDetailVo> selectManageExport(ControlDetailSearchVo vo);

    /**
     * 
    *Description: 根据id查询明细列表记录
    *@param ids
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ControlDetailVo> selectDetailByIds(Long[] ids);
}
