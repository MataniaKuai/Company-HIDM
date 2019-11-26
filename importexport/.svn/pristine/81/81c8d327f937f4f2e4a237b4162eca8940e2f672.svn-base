package com.hidm.importexport.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.ControlDetailDao;
import com.hidm.importexport.entity.ControlDetail;
import com.hidm.importexport.service.ControlDetailService;
import com.hidm.importexport.vo.ControlDetailSearchVo;
import com.hidm.importexport.vo.ControlDetailVo;

@Service(value = "controlDetailService")
public class ControlDetailServiceImpl implements ControlDetailService {
    @Autowired
    private ControlDetailDao controlDetailDao;
    
    public int insert(ControlDetail controlDetail) {
        return controlDetailDao.insert(controlDetail);
    }
    
    public void updateById(ControlDetail controlDetail) {
        controlDetail.setUpdateTime(new Date());
        controlDetailDao.updateById(controlDetail);
    }
    
    public int count(ControlDetailSearchVo controlDetail) {
        return controlDetailDao.count(controlDetail);
    }
    
    public List<ControlDetailVo> selectList(ControlDetailSearchVo controlDetail) {
        return controlDetailDao.selectList(controlDetail);
    }
    
    public List<ControlDetailVo> selectExport(ControlDetailSearchVo controlDetail) {
        return controlDetailDao.selectExport(controlDetail);
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            controlDetailDao.deleteByIds(ids);
        }
    }

    @Override
    public List<ControlDetailVo> selectReportList(ControlDetailSearchVo vo) {
        return controlDetailDao.selectReportList(vo);
    }

    @Override
    public int countReportList(ControlDetailSearchVo vo) {
        return controlDetailDao.countReportList(vo);
    }

    @Override
    public List<ControlDetailVo> selectManageExport(ControlDetailSearchVo vo) {
        return controlDetailDao.selectManageExport(vo);
    }

    @Override
    public List<ControlDetailVo> selectDetailByIds(Long[] ids) {
        return controlDetailDao.selectDetailByIds(ids);
    }
}
