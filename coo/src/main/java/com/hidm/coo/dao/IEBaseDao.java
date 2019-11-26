package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.coo.entity.IEBase;
import com.hidm.coo.vo.IEBaseSearchVo;
import com.hidm.coo.vo.IEBaseVo;

@Mapper
public interface IEBaseDao {
    public int insert(IEBase ieBase);
    
    public void updateById(IEBase ieBase);
    
    public void updateByUserBaseId(IEBase ieBase);
    
    public int count(IEBaseSearchVo ieBase);
    
    public List<IEBaseVo> selectList(IEBaseSearchVo ieBaseVO);
    
    public void deleteByIds(Long[] ids);
    
    public void deleteByUserBaseIds(Long[] ids);

    public List<IEBaseVo> selectAll();

    public List<IEBaseVo> selectInfoByIds(Long[] ids);

    public List<IEBase> selectByUserId(@Param("id")Long id);
}
