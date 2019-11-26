package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.ImportBatchHisDao;
import com.hidm.importexport.entity.ImportBatchHis;
import com.hidm.importexport.service.ImportBatchHisService;
import com.hidm.importexport.vo.ImportBatchHisSearchVo;
import com.hidm.importexport.vo.ImportBatchHisVo;

@Service(value = "ImportBatchHisService")
public class ImportBatchHisServiceImpl implements ImportBatchHisService {
    
    @Autowired
    private ImportBatchHisDao importBatchHisDao;
    
    public int insert(ImportBatchHis importBatchHis) {
        return importBatchHisDao.insert(importBatchHis);
    }
    
    @Override
    public List<ImportBatchHisVo> selectByItemHisId(ImportBatchHisSearchVo vo) {
        return importBatchHisDao.selectByItemHisId(vo);
    }

}
