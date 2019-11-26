package com.hidm.importexport.service;

import java.util.Date;
import java.util.List;

import com.hidm.importexport.entity.Material;
import com.hidm.importexport.vo.MaterialSearchVo;
import com.hidm.importexport.vo.MaterialVo;

/**
 * 
*Description: 处理material数据
*@author GuoRong
*@date 2018年11月30日
*@version 1.0
*
 */
public interface MaterialService {
	/**
	 * 
	*Description: 新增记录
	*@param material
	*@return 
	*@author GuoRong
	*@date 2018年11月30日
	*@version 1.0
	 */
    public int insert(Material material);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param material 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void updateById(Material material);
    
    /**
     * 
    *Description: 查询记录数量
    *@param material
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public int count(MaterialSearchVo material);
    
    /**
     * 
    *Description: 查询记录列表
    *@param material
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<MaterialVo> selectList(MaterialSearchVo material);
    
    /**
     * 
    *Description: 查询报表列表
    *@param material
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<MaterialVo> selectExport(MaterialSearchVo material);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param ids 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
    
    /**
     * 
    *Description: 新增照片附件信息
    *@param fileName
    *@param filePath
    *@param materialId 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public void savePhotoInfo(String fileName, String filePath, Long materialId);
    
    /**
     * 
    *Description: 获取过期日期
    *@param materialNo
    *@param productTime
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public Date getOverdueDate(String materialNo, Date productTime);
    
    /**
     * 
    *Description: 获取描述信息
    *@param materialNo
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public String getDecription(String materialNo);

    /**
     * 
    *Description: 根据id查询记录
    *@param ids
    *@return 
    *@author GuoRong
    *@date 2018年11月30日
    *@version 1.0
     */
    public List<Material> selectMaterialByIds(Long[] ids);
}
