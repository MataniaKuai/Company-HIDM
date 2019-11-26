package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.IEBase;
import com.hidm.coo.vo.IEBaseSearchVo;
import com.hidm.coo.vo.IEBaseVo;

/**
 * 
*Description: 处理OPBase基本数据
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface IEBaseService {
	
	/**
	 * 
	*Description: 新增数据
	*@param OPBase
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public int insert(IEBase ieBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(IEBase ieBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param ieBase
    *@return 
    *@author kmd
    *@date 2019.7.4
    *@version 1.0
     */
    public void updateByUserBaseId(IEBase ieBase);
    
    /**
     * 
    *Description: 查询记录数量
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(IEBaseSearchVo ieBaseVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<IEBaseVo> selectList(IEBaseSearchVo ieBaseVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param OPBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<IEBaseVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    
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
    
    public List<IEBaseVo> selectInfoByIds(Long[] ids);
    /**
     * Description: 与SAP交互
     * @param IEBase
     * @return
     * @author sharon
     */ 
    public IEBase synchToSap(IEBase ieBase);

    public String synchToSAP(Long id);

    public List<IEBase> selectByUserId(Long id);
}
