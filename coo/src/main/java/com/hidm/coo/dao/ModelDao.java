package com.hidm.coo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.coo.entity.ModelType;
import com.hidm.coo.vo.ModelSearchVo;
import com.hidm.coo.vo.ModelVo;


@Mapper
public interface ModelDao {

    public int insert(ModelType model);
    
    public void updateById(ModelType model);
    
    public int count(ModelSearchVo modelSearchVo);
    
    public List<ModelVo> selectList(ModelSearchVo modelSearchVO);
    
    public void deleteByIds(Long[] ids);

    public List<ModelVo> selectAll();

    public List<ModelVo> selectInfoByIds(Long[] ids);

    public List<ModelVo> selectCheckData(ModelSearchVo vo);

    public ModelVo selectByName(String model);
    
}
