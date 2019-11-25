package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.ChartsResult;
import com.hidm.importexport.entity.Material;

public interface ChartsService {
    List<ChartsResult> countMaterial();

    int sync();
    
    void insertMaterials(List<Material> materials);
    
    void insertMaterialHis(List<Material> materials);

    void delMaterialHis();

    void delMaterial();

    List<Material> findByType(String name);
}
