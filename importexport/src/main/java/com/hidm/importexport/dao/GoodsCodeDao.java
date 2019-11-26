package com.hidm.importexport.dao;

import com.hidm.importexport.entity.GoodsCode;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsCodeDao {
    public List<GoodsCode> allGoodsCodes();
}
