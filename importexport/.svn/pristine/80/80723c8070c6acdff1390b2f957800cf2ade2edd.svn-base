package com.hidm.importexport.dao;

import com.hidm.importexport.entity.Asset;
import com.hidm.importexport.vo.AssetSearchVo;
import com.hidm.importexport.vo.AssetVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AssetDao {
    public int insert(Asset asset);
    
    public void updateById(Asset asset);
    
    public int count(AssetSearchVo asset);
    
    public List<AssetVo> selectList(AssetSearchVo asset);
    
    public void deleteByIds(Long[] ids);

    public List<AssetVo> selectExport(AssetSearchVo vo);

    public List<Asset> selectAssetByIds(Long[] ids);
}
