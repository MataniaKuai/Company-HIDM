package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.ImportItemHisDao;
import com.hidm.importexport.entity.ImportItemHis;
import com.hidm.importexport.service.ImportItemHisService;
import com.hidm.importexport.vo.ImportItemHisSearchVo;
import com.hidm.importexport.vo.ImportItemHisVo;

@Service(value = "ImportItemHisService")
public class ImportItemHisServiceImpl implements ImportItemHisService {
    
    @Autowired
    private ImportItemHisDao importItemHisDao;
    
    public int insert(ImportItemHis importItemHis) {
        return importItemHisDao.insert(importItemHis);
    }

    @Override
    public List<ImportItemHisVo> selectByItemId(ImportItemHisSearchVo vo) {
        return importItemHisDao.selectByItemId(vo);
    }

    @Override
    public int countByItemId(ImportItemHisSearchVo vo) {
        return importItemHisDao.countByItemId(vo);
    }

}
