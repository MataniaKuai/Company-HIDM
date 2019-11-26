package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.UserBase;
import com.hidm.coo.vo.UserBaseSearchVo;
import com.hidm.coo.vo.UserBaseVo;

@Mapper
public interface UserBaseDao {
    public int insert(UserBase userBase);
    
    public void updateById(UserBase userBase);
    
    public int count(UserBaseSearchVo userBase);
    
    public List<UserBaseVo> selectList(UserBaseSearchVo userBase);
    
    public void deleteByIds(Long[] ids);
    
    public List<UserBaseVo> selectAll();

    public List<UserBaseVo> selectInfoByIds(Long[] ids);

    public List<UserBaseVo> selectCheckData(UserBaseSearchVo vo);

    public List<UserBaseVo> selectListMc(UserBaseSearchVo vo);

    public int countMc(UserBaseSearchVo vo);
}
