package com.hidm.importexport.service;

import com.hidm.importexport.entity.ImportBatch;
import com.hidm.importexport.vo.ImportBatchSearchVo;
import com.hidm.importexport.vo.ImportBatchVo;
import com.hidm.importexport.vo.ImportItemVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
*Description: 处理批次数据信息
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ImportBatchService {
	
	/**
	 * 
	*Description: 新增单个批次记录
	*@param importBatch
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ImportBatch importBatch);
    
    /**
     * 
    *Description: 新增多个批次记录
    *@param list 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void insertBatch(List<ImportBatch> list);
    
    /**
     * 
    *Description: 根据id更新批次信息
    *@param importBatch 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void updateById(ImportBatch importBatch);
    
    /**
     * 
    *Description: 查询记录数量
    *@param importBatch
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(ImportBatchSearchVo importBatch);
    
    /**
     * 
    *Description: 查询记录列表
    *@param importBatch
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportBatchVo> selectList(ImportBatchSearchVo importBatch);
    
    /**
     * 
    *Description: 根据id查询记录数量
    *@param ids long[]
    *@return int
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int countByImportIds(Long[] ids);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids long[]
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
    
    /**
     * 
    *Description: 新增文件记录信息
    *@param fileName
    *@param filePath
    *@param batchs List<ImportBatch>
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void saveFileInfo(String fileName, String filePath, List<ImportBatch> batchs);
    
    /**
     * 
    *Description: 查询批次信息
    *@param importId
    *@param poNo
    *@param poItem
    *@param materialNo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportBatchVo> getBatchList(Long importId, String poNo, String poItem, String materialNo);
    
    /**
     * 
    *Description: 查询批次中的进口数据数量
    *@param importId
    *@param poNo
    *@param poItem
    *@param materialNo
    *@return BigDecimal
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public BigDecimal calBatchQty(Long importId, String poNo, String poItem, String materialNo);
    
    /**
     * 
    *Description: 检验数量是否和数据中的数据一致
    *@param importId
    *@param itemIds
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportItemVo> checkQty(Long importId, List<Long> itemIds);
    
    /**
     * 
    *Description: 检验当前进口数据是否已经过期
    *@param importId
    *@param itemIds
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportBatchVo> checkOverdue(Long importId, List<Long> itemIds);

    /**
     * 
    *Description: 根据irNo删除批次记录
    *@param irNo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void deleteImportBatchByIrNo(String irNo);
}
