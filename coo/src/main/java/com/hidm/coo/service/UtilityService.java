package com.hidm.coo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hidm.coo.entity.Utility;
import com.hidm.coo.vo.UtilitySearchVo;
import com.hidm.coo.vo.UtilityVo;

/**
 * 
*Description: 获取Utility
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface UtilityService {
    
    /**
     * 
    *Description: 新增数据
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int insert(Utility utility);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(Utility utility);
    
    /**
     * 
    *Description: 查询记录数量
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(UtilitySearchVo utilitySearchVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UtilityVo> selectList(UtilitySearchVo utilityVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param Utility
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UtilityVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<UtilityVo> selectInfoByIds(Long[] ids);

    /**
     * Description: 根据utilityNo查询utility记录
     * @param utility
     * @return
     */
	public ArrayList<UtilityVo> selectByUtilityNo(String utility);

    public List<UtilityVo> selectInfoByUtilityNo(UtilityVo utilityVo);

    public List<UtilityVo> selectCheckData(UtilitySearchVo vo);
    
    public Map<String, String> getUtilityPrice(List<UtilityVo> list);

    public List<UtilityVo> selectInfoByNos(String[] utilityNameArr);
}
