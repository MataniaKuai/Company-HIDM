package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.vo.MaterialInventorySearchVo;
import com.hidm.importexport.vo.MaterialInventoryVo;

/**
 * 
*Description: 处理原材料数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface MaterialInventoryService {

	/**
	 * 
	*Description: 查询列表记录
	*@param vo
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public List<MaterialInventoryVo> selectList(MaterialInventorySearchVo vo);

    /**
     * 
    *Description: 查询记录数量
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public int countList(MaterialInventorySearchVo vo);

    /**
     * 
    *Description: 根据月份查询记录
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<MaterialInventoryVo> selectHistMon();

    /**
     * 
    *Description: 查询报表记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<MaterialInventoryVo> selectExport(MaterialInventorySearchVo vo);
}
