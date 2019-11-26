package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.EQtypeDao;
import com.hidm.coo.entity.EQtype;
import com.hidm.coo.service.EQtypeService;
import com.hidm.coo.vo.EQtypeSearchVo;
import com.hidm.coo.vo.EQtypeVo;

@Service(value = "eqTypeService")
public class EQtypeServiceImpl implements EQtypeService {
    @Autowired
    private EQtypeDao eqTypeDao;


    @Override
    public int insert(EQtype eqtype) {
        return eqTypeDao.insert(eqtype);
    }

    @Override
    public void updateById(EQtype eqtype) {
        eqTypeDao.updateById(eqtype);
    }

    @Override
    public int count(EQtypeSearchVo eqtypeVO) {
        return eqTypeDao.count(eqtypeVO);
    }

    @Override
    public List<EQtypeVo> selectList(EQtypeSearchVo eqtypeVO) {
        return eqTypeDao.selectList(eqtypeVO);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        eqTypeDao.deleteByIds(ids);
    }

    @Override
    public List<EQtypeVo> selectAll() {
        return eqTypeDao.selectAll();
    }

    @Override
    public List<EQtypeVo> selectInfoByIds(Long[] ids) {
        return eqTypeDao.selectInfoByIds(ids);
    }

    @Override
    public List<EQtypeVo> selectCheckData(EQtypeSearchVo vo) {
        return eqTypeDao.selectCheckData(vo);
    }
    
    @Override
    public List<EQtypeVo> selectInfoByModules(String[] modules){
    	return eqTypeDao.selectInfoByModules(modules);
    }
}
