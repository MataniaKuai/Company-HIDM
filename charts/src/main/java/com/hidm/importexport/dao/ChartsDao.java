package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.ChartsResult;
import com.hidm.importexport.entity.Material;

@Mapper
public interface ChartsDao {
    public List<ChartsResult> countMaterial();

    public void insertMaterials(List<Material> materials);

    public void insertMaterialHis(List<Material> materials);

    public void delMaterialHis(int days);

    public void delMaterial();

    public List<Material> findByType(String name);
}
