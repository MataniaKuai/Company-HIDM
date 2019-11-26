package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.vo.EQMouduleVo;

@Mapper
public interface EQMouduleDao {

    public List<EQMouduleVo> selectAll();
    
}
