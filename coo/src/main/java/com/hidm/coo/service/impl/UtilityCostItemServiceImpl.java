package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.UtilityCostItemDao;
import com.hidm.coo.entity.UtilityCostItem;
import com.hidm.coo.service.UtilityCostItemService;
import com.hidm.coo.vo.UtilityCostItemSearchVo;
import com.hidm.coo.vo.UtilityCostItemVo;

@Service(value = "utilityCostItemService")
public class UtilityCostItemServiceImpl implements UtilityCostItemService {
    @Autowired
    private UtilityCostItemDao utilityCostItemDao;


    @Override
    public int insert(UtilityCostItem utilityCostItem) {
        return utilityCostItemDao.insert(utilityCostItem);
    }

    @Override
    public void updateById(UtilityCostItem utilityCostItem) {
    	utilityCostItemDao.updateById(utilityCostItem);
    }

    @Override
    public int count(UtilityCostItemSearchVo utilityCostItemSearchVo) {
        return utilityCostItemDao.count(utilityCostItemSearchVo);
    }

    @Override
    public List<UtilityCostItemVo> selectList(UtilityCostItemSearchVo utilityCostItemSearchVo) {
        return utilityCostItemDao.selectList(utilityCostItemSearchVo);
    }

    @Override
    public void deleteByIds(Long[] ids) {
    	utilityCostItemDao.deleteByIds(ids);
    }
    
    @Override
    @Transactional
    public void deleteByUserBaseIds(Long[] ids) {
    	utilityCostItemDao.deleteByUserBaseIds(ids);
    }

    @Override
    public List<UtilityCostItemVo> selectAll() {
        return utilityCostItemDao.selectAll();
    }

    @Override
    public List<UtilityCostItemVo> selectInfoByIds(Long[] ids) {
        return utilityCostItemDao.selectInfoByIds(ids);
    }
    @Override
    public List<UtilityCostItemVo> searchInfo(UtilityCostItemVo utilityCostItemVo){
    	return utilityCostItemDao.searchInfo(utilityCostItemVo);
    }

	@Override
	public List<UtilityCostItemVo> selectInfo(UtilityCostItemVo utilityCostItemVo) {
		// TODO Auto-generated method stub
		return utilityCostItemDao.selectInfo(utilityCostItemVo);
	}
}
