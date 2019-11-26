package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.OthersDao;
import com.hidm.coo.entity.Others;
import com.hidm.coo.service.OthersService;
import com.hidm.coo.vo.OthersSearchVo;
import com.hidm.coo.vo.OthersVo;

@Service(value = "othersService")
public class OthersServiceImpl implements OthersService {
    @Autowired
    private OthersDao othersDao;


    @Override
    public int insert(Others others) {
        return othersDao.insert(others);
    }

    @Override
    public void updateById(Others others) {
        othersDao.updateById(others);
    }

    @Override
    public int count(OthersSearchVo othersVO) {
        return othersDao.count(othersVO);
    }

    @Override
    public List<OthersVo> selectList(OthersSearchVo othersVO) {
        return othersDao.selectList(othersVO);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        othersDao.deleteByIds(ids);
    }

    @Override
    public List<OthersVo> selectAll() {
        return othersDao.selectAll();
    }

    @Override
    public List<OthersVo> selectInfoByIds(Long[] ids) {
        return othersDao.selectInfoByIds(ids);
    }
    
    public Others selectByName(String name) {
        return othersDao.selectByName(name);
    }

    public Others selectById(Long id) {
        return othersDao.selectById(id);
    }

    @Override
    public List<OthersVo> selectCheckData(OthersSearchVo vo) {
        return othersDao.selectCheckData(vo);
    }
}
