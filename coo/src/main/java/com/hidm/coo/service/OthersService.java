package com.hidm.coo.service;

import java.util.List;

import com.hidm.coo.entity.Others;
import com.hidm.coo.vo.OthersSearchVo;
import com.hidm.coo.vo.OthersVo;

/**
 * 
*Description: 获取其他参数
*@author yl
*@date 2019.6.13
*@version 1.0
*
 */
public interface OthersService {
    
    /**
     * 
    *Description: 新增数据
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int insert(Others others);
    
    /**
     * 
    *Description: 根据id更新记录
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void updateById(Others others);
    
    /**
     * 
    *Description: 查询记录数量
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public int count(OthersSearchVo othersVO);
    
    /**
     * 
    *Description: 查询记录列表
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<OthersVo> selectList(OthersSearchVo othersVO);
    
    /**
     * 
    *Description: 根据id删除记录
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public void deleteByIds(Long[] ids);

    /**
     * 
    *Description: 查询所有信息
    *@param Others
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<OthersVo> selectAll();

    /**
     * 
    *Description: 根据id查询记录
    *@param ids Long[]
    *@return 
    *@author yl
    *@date 2019.6.13
    *@version 1.0
     */
    public List<OthersVo> selectInfoByIds(Long[] ids);
    
	/**
	 * 
	*Description: 根据名称查询
	*@return 
	*@author yl
	*@date 2019.6.13
	*@version 1.0
	 */
    public Others selectByName(String name);

    /**
     * 根据id查询
     * @param id
     */
    public Others selectById(Long id);

    public List<OthersVo> selectCheckData(OthersSearchVo vo);
}
