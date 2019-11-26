package com.hidm.coo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.MaterialsCostItem;
import com.hidm.coo.vo.MaterialsCostItemSearchVo;
import com.hidm.coo.vo.MaterialsCostItemVo;

@Mapper
public interface MaterialsCostItemDao {

    public int insert(MaterialsCostItem materialsCostItem);
    
    public void updateById(MaterialsCostItem materialsCostItem);
    
    public int count(MaterialsCostItemSearchVo materialsCostItemSearchVo);
    
    public List<MaterialsCostItemVo> selectList(MaterialsCostItemSearchVo materialsCostItemSearchVo);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByUserBaseIds(Long[] ids);

    public List<MaterialsCostItemVo> selectAll();

    public List<MaterialsCostItemVo> selectInfoByIds(Long[] ids);
    
    public List<MaterialsCostItemVo> searchInfo(MaterialsCostItemVo materialsCostItemVo);

	public ArrayList<MaterialsCostItemVo> selectByUserBaseId(Long userBaseId);
}
