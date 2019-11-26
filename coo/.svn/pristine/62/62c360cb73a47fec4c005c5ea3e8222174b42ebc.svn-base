package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.VendorDao;
import com.hidm.coo.entity.Vendor;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.vo.VendorSearchVo;
import com.hidm.coo.vo.VendorVo;


@Service(value = "vendorService")
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorDao vendorDao;


    @Override
    public int insert(Vendor vendor) {
        return vendorDao.insert(vendor);
    }

    @Override
    public void updateById(Vendor vendor) {
    	vendorDao.updateById(vendor);
    }

    @Override
    public int count(VendorSearchVo vendorVO) {
        return vendorDao.count(vendorVO);
    }

    @Override
    public List<VendorVo> selectList(VendorSearchVo vendorSearchVo) {
        return vendorDao.selectList(vendorSearchVo);
    }

    @Override
    public void deleteByIds(Long[] ids) {
    	vendorDao.deleteByIds(ids);
    }

    @Override
    public List<VendorVo> selectAll() {
        return vendorDao.selectAll();
    }

    @Override
    public List<VendorVo> selectInfoByIds(Long[] ids) {
        return vendorDao.selectInfoByIds(ids);
    }
    @Override
    public List<VendorVo> selectCheckData(VendorSearchVo vo) {
        return vendorDao.selectCheckData(vo);
    }

    @Override
    public VendorVo selectByName(String vendor) {
        return vendorDao.selectByName(vendor);
    }
}
