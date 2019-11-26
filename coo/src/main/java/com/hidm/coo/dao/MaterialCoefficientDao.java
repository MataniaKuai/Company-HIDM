package com.hidm.coo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.MaterialCoefficient;
import com.hidm.coo.vo.MaterialCoefficientSearchVo;
import com.hidm.coo.vo.MaterialCoefficientVo;

@Mapper
public interface MaterialCoefficientDao {

    public int insert(MaterialCoefficient materialCoefficient);
    
    public void updateById(MaterialCoefficient materialCoefficient);
    
    public int count(MaterialCoefficientSearchVo materialCoefficient);
    
    public List<MaterialCoefficientVo> selectList(MaterialCoefficientSearchVo materialCoefficientVO);
    
    public void deleteByIds(Long[] ids);

    public List<MaterialCoefficientVo> selectAll();

    public List<MaterialCoefficientVo> selectInfoByIds(Long[] ids);

	public ArrayList<MaterialCoefficientVo> selectByMaterialNo(String materialNo);

    public List<MaterialCoefficientVo> selectInfoByMaterialNo(MaterialCoefficientVo materialCoefficientVo);

    public List<MaterialCoefficientVo> selectCheckData(MaterialCoefficientSearchVo vo);

    public List<MaterialCoefficientVo> selectInfoByNos(String[] materialNameArr);

}
