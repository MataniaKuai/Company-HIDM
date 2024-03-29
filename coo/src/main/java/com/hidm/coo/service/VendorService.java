package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.Vendor;
import com.hidm.coo.vo.VendorSearchVo;
import com.hidm.coo.vo.VendorVo;

/**
 * 
*Description: 获取EQtype
*@author kmd
*@date 2019.7.1
*@version 1.0
*
 */
public interface VendorService {
    
    /**
     * 
    *Description: 新增数据
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public int insert(Vendor vendor);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public void updateById(Vendor vendor);
    
    /**
     * 
    *Description: 查询记录数量
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public int count(VendorSearchVo vendorSearchVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public List<VendorVo> selectList(VendorSearchVo vendorSearchVo);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public List<VendorVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public List<VendorVo> selectInfoByIds(Long[] ids);
    
    public List<VendorVo> selectCheckData(VendorSearchVo vo);

    public VendorVo selectByName(String vendor);
    
}
