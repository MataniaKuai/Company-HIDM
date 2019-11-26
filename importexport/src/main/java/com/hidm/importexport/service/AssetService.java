package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.Asset;
import com.hidm.importexport.vo.AssetSearchVo;
import com.hidm.importexport.vo.AssetVo;

/**
 * 
*Description: 处理资产相关的业务逻辑
*@author GuoRong
*@date 2018年11月28日
*@version 1.0
*
 */
public interface AssetService {
	/**
	 * 
	*Description: 新增assert记录
	*@author GuoRong
	*@date 2018年11月28日
	*@version 1.0
	*@return int
	 */
    public int insert(Asset asset);
    
    /**
     * 
    *Description: 更新asset记录
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@return void
     */
    public void updateById(Asset asset);
    
    /**
     * 
    *Description:查询符合条件的asset记录数
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@return int
     */
    public int count(AssetSearchVo asset);
    
    /**
     * 
    *Description:查询符合条件的asset对象
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@return List<AssetVo>  返回asset对象列表
     */
    public List<AssetVo> selectList(AssetSearchVo asset);
    
    /**
     * 
    *Description: 根据asset的id进行删除符合条件的记录
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@return void
     */
    public void deleteByIds(Long[] ids);
    
    /**
     * 
    *Description: 保存asset的图片附件
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@return void
     */
    public void savePhotoInfo(String fileName, String filePath, Long assetId);

    /**
     * 
    *Description: 查询报表记录
    *@author GuoRong
    *@date 2018年11月28日
    *@version 1.0
    *@parameter
    *@return List<AssetVo>
     */
    public List<AssetVo> selectExport(AssetSearchVo vo);
    
    /**
     * 
    *Description: 查询asset描述信息
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return String
     */
    public String getDecription(String assetNo);
    
    /**
     * 
    *Description: 根据asset的id查询对应的asset记录
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
    *@parameter
    *@return List<Asset>
     */
    public List<Asset> selectAssetByIds(Long[] ids);
}
