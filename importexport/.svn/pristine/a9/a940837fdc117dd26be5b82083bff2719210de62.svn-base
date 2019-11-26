package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.MaterialInventoryDao;
import com.hidm.importexport.service.MaterialInventoryService;
import com.hidm.importexport.vo.MaterialInventorySearchVo;
import com.hidm.importexport.vo.MaterialInventoryVo;

@Service(value = "MaterialInventoryService")
public class MaterialInventoryServiceImpl implements MaterialInventoryService {
    
    @Autowired
    private MaterialInventoryDao materialInventoryDao;

    @Override
    public List<MaterialInventoryVo> selectList(MaterialInventorySearchVo vo) {
        return materialInventoryDao.selectList(vo);
    }

    @Override
    public int countList(MaterialInventorySearchVo vo) {
        return materialInventoryDao.countList(vo);
    }

    @Override
    public List<MaterialInventoryVo> selectHistMon() {
        return materialInventoryDao.selectHistMon();
    }

    @Override
    public List<MaterialInventoryVo> selectExport(MaterialInventorySearchVo vo) {
        return materialInventoryDao.selectExport(vo);
    }
    

}
