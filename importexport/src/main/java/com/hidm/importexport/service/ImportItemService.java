package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;

/**
 * 
*Description: 处理importitem业务
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ImportItemService {
	
	/**
	 * 
	*Description: 新增记录
	*@param importInfo
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ImportItem importInfo);
    
    /**
     * 
    *Description: 根据importItem新增批次记录
    *@param importItems List<ImportItem>
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void insertBatch(List<ImportItem> importItems);
    
    /**
     * 
    *Description: 同步数据
    *@param poNo
    *@param importId
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int sync(String poNo, Long importId);
    
    /**
     * 
    *Description: 根据id更新数据
    *@param importInfo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void updateById(ImportItem importInfo);
    
    /**
     * 
    *Description: 查询记录数量
    *@param importItem
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(ImportItemSearchVo importItem);
    
    /**
     * 
    *Description: 查询记录列表
    *@param importInfo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportItemVo> selectList(ImportItemSearchVo importInfo);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids Long[]
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 根据grNo查询记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportItemVo> selectListByGrNo(ImportItemSearchVo vo);

    /**
     * 
    *Description: 查询为收货记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int countUnReceived(ImportItemSearchVo vo);
    
    /**
     * 
    *Description: 查询已经收货记录数量
    *@param importItem
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int countReceived(ImportItemSearchVo importItem);

    /**
     * 
    *Description: 
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int selectCountByGrNo(ImportItemSearchVo vo);

    /**
     * 
    *Description: 新增item记录
    *@param items List<ImportItem>
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void insertItems(List<ImportItem> items);

    /**
     * 
    *Description: 根据id查询item
    *@param itemIds Long[]
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<ImportItemVo> selectByIds(Long[] itemIds);

    /**
     * 
    *Description: 根据id查询item
    *@param ids
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<ImportItemVo> selectImportItemByIds(Long[] ids);
    
}
