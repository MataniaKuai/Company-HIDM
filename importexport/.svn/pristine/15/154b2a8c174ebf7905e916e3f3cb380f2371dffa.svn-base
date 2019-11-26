package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ImportInfo;
import com.hidm.importexport.vo.ImportInfoSearchVo;
import com.hidm.importexport.vo.ImportInfoVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;
import com.hidm.importexport.vo.ImportReportVo;
import com.hidm.importexport.vo.ReceiveVo;

/**
 * 
*Description: 处理进口数据
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
public interface ImportInfoService {
	
	/**
	 * 
	*Description: 新增进口数据记录
	*@param importInfo
	*@return 
	*@author GuoRong
	*@date 2018年11月29日
	*@version 1.0
	 */
    public int insert(ImportInfo importInfo);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param importInfo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void updateById(ImportInfo importInfo);
    
    /**
     * 
    *Description: 查询记录数量
    *@param importInfo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int count(ImportInfoSearchVo importInfo);
    
    /**
     * 
    *Description: 查询记录列表
    *@param importInfo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportInfoVo> selectList(ImportInfoSearchVo importInfo);
    
    /**
     * 
    *Description: 报表查询记录数量
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int reportCount(ImportItemSearchVo vo);
    
    /**
     * 
    *Description: 查询报表列表记录
    *@param vo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportReportVo> selectReportList(ImportItemSearchVo vo);
    
    /**
     * 
    *Description: 查询报表记录列表
    *@param importInfo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportReportVo> selectExport(ImportItemSearchVo importInfo);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids Long[]
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public int deleteByIds(Long[] ids);
    
    /**
     * Description: 收货业务逻辑
     * @param itemIds  每条importItem的id数组
     * @param stocks   每条importItem的库存地点数组
     * @param importId  当前importItem对应的importId
     * @param isBatch  是否是按批次收货  值为1按批次  否则不按批次
     * @param model 
     * @param session  
     * @return  ReceiveVo 向页面传递错误信息
     */
    public ReceiveVo receive(List<Long>  itemIds, Long importId, Integer isBatch, String[] stocks);
    
    /**
     * 
    *Description: 根据irNo查询记录
    *@param irNo
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public ImportInfoVo selectByIrNo(String irNo);
    
    /**
     * 
    *Description: 调用SAP接口取消收货
    *@param itemList
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public String unReceive(List<ImportItemVo> itemList);

    /**
     * 
    *Description: 取消收货后更新进口数据记录
    *@param grYear
    *@param grNo
    *@param moveType
    *@param itemList
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public String updateUnreceiveInfo(int grYear, String grNo, String moveType, List<ImportItemVo> itemList);
    
    /**
     * 
    *Description: 新增进口数据
    *@param imports List<ImportInfo>
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void insertImports(List<ImportInfo> imports);

    /**
     * 
    *Description: 查询所有进口数据信息
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportInfoVo> selectAll();

    /**
     * 
    *Description: release后更新进口数据信息
    *@param importInfo
    *@param empNo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void releaseUpdate(ImportInfo importInfo, String empNo);

    /**
     * 
    *Description: unrelease后更新记录
    *@param importInfo
    *@param empNo 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public void unreleaseUpdate(ImportInfo importInfo, String empNo);

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    public List<ImportInfoVo> selectImportInfoByIds(Long[] ids);

	public String checkVendor(ImportInfo importInfo);

}
