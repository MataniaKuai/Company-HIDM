package com.hidm.importexport.dao;

import com.hidm.importexport.entity.Material;
import com.hidm.importexport.vo.MaterialSearchVo;
import com.hidm.importexport.vo.MaterialVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaterialDao {
    public int insert(Material material);
    
    public void updateById(Material material);
    
    public int count(MaterialSearchVo material);
    
    public List<MaterialVo> selectList(MaterialSearchVo material);
    
    public List<MaterialVo> selectExport(MaterialSearchVo material);
    
    public void deleteByIds(Long[] ids);

    public List<Material> selectMaterialByIds(Long[] ids);
}
