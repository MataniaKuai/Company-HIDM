package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.coo.entity.OPBase;
import com.hidm.coo.vo.OPBaseSearchVo;
import com.hidm.coo.vo.OPBaseVo;

@Mapper
public interface OPBaseDao {
    public int insert(OPBase opBase);
    
    public void updateById(OPBase opBase);
    
    public int count(OPBaseSearchVo opBase);
    
    public List<OPBaseVo> selectList(OPBaseSearchVo opBaseVO);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByUserBaseIds(Long[] ids);

    public List<OPBaseVo> selectAll();

    public List<OPBaseVo> selectInfoByIds(Long[] ids);

    public List<OPBase> selectByUserId(@Param("id")Long id);
}
