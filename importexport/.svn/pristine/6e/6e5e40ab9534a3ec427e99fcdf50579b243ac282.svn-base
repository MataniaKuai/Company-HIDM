package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.ReleaseHisDao;
import com.hidm.importexport.entity.ReleaseHis;
import com.hidm.importexport.service.ReleaseHisService;
import com.hidm.importexport.vo.ReleaseHisSearchVo;
import com.hidm.importexport.vo.ReleaseHisVo;


@Service(value = "releaseHisService")
public class ReleaseHisServiceImpl implements ReleaseHisService {

    @Autowired
    private ReleaseHisDao releaseHisDao;
    
    @Override
    public void insert(ReleaseHis releaseHis) {
        releaseHisDao.insert(releaseHis);
    }
    
    @Override
    public int count(ReleaseHisSearchVo releaseHis) {
        return releaseHisDao.count(releaseHis);
    }
    
    @Override
    public List<ReleaseHisVo> selectReportList(ReleaseHisSearchVo releaseHis) {
        return releaseHisDao.selectReportList(releaseHis);
    }
    
    @Override
    public List<ReleaseHisVo> selectExport(ReleaseHisSearchVo release){
    	return releaseHisDao.selectExport(release);
    };
}
