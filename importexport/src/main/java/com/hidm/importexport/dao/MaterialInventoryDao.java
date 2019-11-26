package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.vo.MaterialInventorySearchVo;
import com.hidm.importexport.vo.MaterialInventoryVo;

@Mapper
public interface MaterialInventoryDao {

    public List<MaterialInventoryVo> selectList(MaterialInventorySearchVo vo);

    public int countList(MaterialInventorySearchVo vo);

    public List<MaterialInventoryVo> selectHistMon();

    public List<MaterialInventoryVo> selectExport(MaterialInventorySearchVo vo);
}
