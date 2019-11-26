package com.hidm.coo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.Utility;
import com.hidm.coo.vo.UtilitySearchVo;
import com.hidm.coo.vo.UtilityVo;

@Mapper
public interface UtilityDao {

    public int insert(Utility utility);
    
    public void updateById(Utility utility);
    
    public int count(UtilitySearchVo utility);
    
    public List<UtilityVo> selectList(UtilitySearchVo utilityVO);
    
    public void deleteByIds(Long[] ids);

    public List<UtilityVo> selectAll();

    public List<UtilityVo> selectInfoByIds(Long[] ids);

	public ArrayList<UtilityVo> selectByUtiltyNo(String utility);

    public List<UtilityVo> selectInfoByUtilityNo(UtilityVo utilityVo);

    public List<UtilityVo> selectCheckData(UtilitySearchVo vo);

    public List<UtilityVo> selectInfoByNos(String[] utilityNameArr);

}
