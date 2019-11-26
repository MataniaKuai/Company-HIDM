package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.UtilityCostItem;
import com.hidm.coo.vo.UtilityCostItemSearchVo;
import com.hidm.coo.vo.UtilityCostItemVo;

@Mapper
public interface UtilityCostItemDao {

    public int insert(UtilityCostItem utilityCostItem);
    
    public void updateById(UtilityCostItem utilityCostItem);
    
    public int count(UtilityCostItemSearchVo utilityCostItemSearchVo);
    
    public List<UtilityCostItemVo> selectList(UtilityCostItemSearchVo utilityCostItemSearchVo);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByUserBaseIds(Long[] ids);

    public List<UtilityCostItemVo> selectAll();

    public List<UtilityCostItemVo> selectInfoByIds(Long[] ids);
    
    public List<UtilityCostItemVo> searchInfo(UtilityCostItemVo utilityCostItemVo);

	public List<UtilityCostItemVo> selectInfo(UtilityCostItemVo utilityCostItemVo);
}
