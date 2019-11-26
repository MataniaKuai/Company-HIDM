package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.PROBase;
import com.hidm.coo.vo.PROBaseSearchVo;
import com.hidm.coo.vo.PROBaseVo;


/**
 * 
*Description: 处理PRO基本数据
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface PROBaseService {
	
	/**
	 * 
	*Description: 新增数据
	*@param PROBase
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public int insert(PROBase proBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param PROBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(PROBase proBase);
    
    /**
     * 
    *Description: 查询记录数量
    *@param PROBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(PROBaseSearchVo proBaseVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param PROBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<PROBaseVo> selectList(PROBaseSearchVo proBaseVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param PROBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);
    
    /**
     * 
    *Description: 根据UserBaseId删除记录
    *@param PROBase
    *@return 
    *@author kmd
    *@date 2019.6.20
    *@version 1.0
     */
    public void deleteByUserBaseIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param PROBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<PROBaseVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<PROBaseVo> selectInfoByIds(Long[] ids);

    /**
     * Description: 与SAP交互
     * @param proBase
     * @return
     * @author 
     */
    public PROBase synchToSap(PROBase proBase);

    public List<PROBase> selectByUserId(Long id);
}
