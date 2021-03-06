package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.ModelType;
import com.hidm.coo.vo.ModelSearchVo;
import com.hidm.coo.vo.ModelVo;

/**
 * 
*Description: 获取EQtype
*@author kmd
*@date 2019.7.1
*@version 1.0
*
 */
public interface ModelService {
    
    /**
     * 
    *Description: 新增数据
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public int insert(ModelType model);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public void updateById(ModelType model);
    
    /**
     * 
    *Description: 查询记录数量
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public int count(ModelSearchVo modelSearchVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param EQtype
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public List<ModelVo> selectList(ModelSearchVo modelSearchVo);
    
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
    public List<ModelVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public List<ModelVo> selectInfoByIds(Long[] ids);

    public List<ModelVo> selectCheckData(ModelSearchVo vo);

    public ModelVo selectByName(String model);
    
}
