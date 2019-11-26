package com.hidm.importexport.dao;

import com.hidm.importexport.entity.InOut;
import com.hidm.importexport.vo.InOutSearchVo;
import com.hidm.importexport.vo.InOutVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InOutDao {
    public int insert(InOut inout);
    
    public void updateById(InOut inout);
    
    public int count(InOutSearchVo inout);
    
    public List<InOutVo> selectList(InOutSearchVo inout);
    
    public List<InOutVo> selectExport(InOutSearchVo inout);
    
    public void deleteByIds(Long[] ids);
}
