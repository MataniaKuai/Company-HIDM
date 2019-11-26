package com.hidm.importexport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.MaterialOrAssetSearchDao;
import com.hidm.importexport.service.MaterialOrAssetSearchService;
import com.hidm.importexport.vo.MaterialOrAssetSearchVo;
import com.hidm.importexport.vo.MaterialVo;

@Service("materialOrAssetSearchService")
public class materialOrAssetSearchServiceImpl implements MaterialOrAssetSearchService {
    
    @Autowired
    private MaterialOrAssetSearchDao materialOrAssetSearchDao;

    @Override
    public int count(MaterialOrAssetSearchVo vo) {
        int total = materialOrAssetSearchDao.count(vo);
        return total;
    }

    @Override
    public List<MaterialVo> selectList(MaterialOrAssetSearchVo vo) {
        List<MaterialVo> list = materialOrAssetSearchDao.selectList(vo);
        return list;
    }

    @Override
    public List<MaterialVo> selectExport(MaterialOrAssetSearchVo vo) {
        return materialOrAssetSearchDao.selectExport(vo);
    }

}
