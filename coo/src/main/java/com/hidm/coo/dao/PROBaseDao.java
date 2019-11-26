package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.coo.entity.PROBase;
import com.hidm.coo.vo.PROBaseSearchVo;
import com.hidm.coo.vo.PROBaseVo;

@Mapper
public interface PROBaseDao {
    public int insert(PROBase proBase);
    
    public void updateById(PROBase proBase);
    
    public int count(PROBaseSearchVo proBaseVO);
    
    public List<PROBaseVo> selectList(PROBaseSearchVo proBaseVO);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByUserBaseIds(Long[] ids);

    public List<PROBaseVo> selectAll();

    public List<PROBaseVo> selectInfoByIds(Long[] ids);

    public List<PROBase> selectByUserId(@Param("id")Long id);
}
