package com.hidm.importexport.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.InOutDao;
import com.hidm.importexport.entity.InOut;
import com.hidm.importexport.service.InOutService;
import com.hidm.importexport.vo.InOutSearchVo;
import com.hidm.importexport.vo.InOutVo;

@Service(value = "inoutService")
public class InOutServiceImpl implements InOutService {
    @Autowired
    private InOutDao inoutDao;
    
    public int insert(InOut inout) {
        return inoutDao.insert(inout);
    }
    
    public void updateById(InOut inout) {
        inout.setUpdateTime(new Date());
        inoutDao.updateById(inout);
    }
    
    public int count(InOutSearchVo inout) {
        return inoutDao.count(inout);
    }
    
    public List<InOutVo> selectList(InOutSearchVo inout) {
        return inoutDao.selectList(inout);
    }
    
    public List<InOutVo> selectExport(InOutSearchVo inout) {
        return inoutDao.selectExport(inout);
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            inoutDao.deleteByIds(ids);
        }
    }
}
