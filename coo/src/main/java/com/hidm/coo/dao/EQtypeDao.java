package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.coo.entity.EQtype;
import com.hidm.coo.vo.EQtypeSearchVo;
import com.hidm.coo.vo.EQtypeVo;

@Mapper
public interface EQtypeDao {

    public int insert(EQtype eqtype);
    
    public void updateById(EQtype eqtype);
    
    public int count(EQtypeSearchVo eqtype);
    
    public List<EQtypeVo> selectList(EQtypeSearchVo eqtypeVO);
    
    public void deleteByIds(Long[] ids);

    public List<EQtypeVo> selectAll();

    public List<EQtypeVo> selectInfoByIds(Long[] ids);

    public List<EQtypeVo> selectCheckData(EQtypeSearchVo vo);
    
    public List<EQtypeVo> selectInfoByModules(@Param("modules") String[] modules);
    
}
