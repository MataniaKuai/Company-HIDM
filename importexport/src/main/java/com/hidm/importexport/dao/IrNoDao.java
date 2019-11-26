package com.hidm.importexport.dao;

import com.hidm.importexport.entity.IrNo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IrNoDao {
    public int insert(IrNo irNo);
    
    public void updateById(IrNo irNo);
    
    public List<IrNo> selectList(IrNo irNo);
    
    public List<IrNo> selectForUpate(IrNo irNo);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByYears(Long[] years);
}
