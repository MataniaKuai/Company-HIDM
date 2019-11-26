package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.vo.MaterialOrAssetSearchVo;
import com.hidm.importexport.vo.MaterialVo;

/**
 * 
*Description: 处理报表一的数据（material、asset）
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface MaterialOrAssetSearchService {

	/**
	 * 
	*Description: 查询记录数量
	*@param vo
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    int count(MaterialOrAssetSearchVo vo);

    /**
     * 
    *Description: 查询记录列表
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    List<MaterialVo> selectList(MaterialOrAssetSearchVo vo);

    /**
     * 
    *Description: 查询报表记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    List<MaterialVo> selectExport(MaterialOrAssetSearchVo vo);
    
}
