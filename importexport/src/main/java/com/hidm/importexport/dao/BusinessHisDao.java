package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.BusinessHis;
import com.hidm.importexport.vo.BusinessHisSearchVo;

@Mapper
public interface BusinessHisDao {

    public void insert(BusinessHis business);
    
    public int count(BusinessHisSearchVo businessHis);
    

    public List<BusinessHisSearchVo> selectList(BusinessHisSearchVo businessHis);
    
}
