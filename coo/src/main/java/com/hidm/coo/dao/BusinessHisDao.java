package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.BusinessHis;
import com.hidm.coo.vo.BusinessHisSearchVo;

@Mapper
public interface BusinessHisDao {

    public void insert(BusinessHis business);
    
    public int count(BusinessHisSearchVo businessHis);
    

    public List<BusinessHisSearchVo> selectList(BusinessHisSearchVo businessHis);
    
}
