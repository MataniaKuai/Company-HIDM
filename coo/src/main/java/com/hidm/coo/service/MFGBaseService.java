package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.MFGBase;
import com.hidm.coo.entity.UserBase;
import com.hidm.coo.vo.MFGBaseSearchVo;
import com.hidm.coo.vo.MFGBaseVo;

/**
 * 
*Description: 处理MFG基本数据
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface MFGBaseService {
	
	/**
	 * 
	*Description: 新增数据
	*@param MFGBase
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public int insert(MFGBase mfgBase);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param MFGBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(MFGBase mfgBase);
    
    /**
     * 
    *Description: 查询记录数量
    *@param MFGBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(MFGBaseSearchVo mfgBaseVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param MFGBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MFGBaseVo> selectList(MFGBaseSearchVo mfgBaseVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param MFGBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param MFGBase
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MFGBaseVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<MFGBaseVo> selectInfoByIds(Long[] ids);

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
     * Description: 与SAP交互
     * @param mfgBase
     * @return 
     * @author sharon
     */
    public MFGBase synchToSap(MFGBase mfgBase);
    
    /**
     * 
     * @param userBase
     * @return	计算ex_olCost
     * @author kmd
     * @date 2019.7.3
     * @version 1.0
     */
    public MFGBase synchToSap2(MFGBase mfgBase);

    public List<MFGBase> selectByUserId(Long id);
}
