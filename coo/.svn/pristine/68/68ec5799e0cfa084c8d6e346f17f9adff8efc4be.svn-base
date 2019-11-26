package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.ModelDao;
import com.hidm.coo.entity.ModelType;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.vo.ModelSearchVo;
import com.hidm.coo.vo.ModelVo;


@Service(value = "modelService")
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelDao modelDao;


    @Override
    public int insert(ModelType model) {
        return modelDao.insert(model);
    }

    @Override
    public void updateById(ModelType model) {
    	modelDao.updateById(model);
    }

    @Override
    public int count(ModelSearchVo modelSearchVo) {
        return modelDao.count(modelSearchVo);
    }

    @Override
    public List<ModelVo> selectList(ModelSearchVo modelSearchVo) {
        return modelDao.selectList(modelSearchVo);
    }

    @Override
    public void deleteByIds(Long[] ids) {
    	modelDao.deleteByIds(ids);
    }

    @Override
    public List<ModelVo> selectAll() {
        return modelDao.selectAll();
    }

    @Override
    public List<ModelVo> selectInfoByIds(Long[] ids) {
        return modelDao.selectInfoByIds(ids);
    }

    @Override
    public List<ModelVo> selectCheckData(ModelSearchVo vo) {
        return modelDao.selectCheckData(vo);
    }

    @Override
    public ModelVo selectByName(String model) {
        return modelDao.selectByName(model);
    }
}
