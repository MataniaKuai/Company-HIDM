package com.hidm.coo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.MaterialsCostItemDao;
import com.hidm.coo.entity.MaterialsCostItem;
import com.hidm.coo.service.MaterialsCostItemService;
import com.hidm.coo.vo.MaterialsCostItemSearchVo;
import com.hidm.coo.vo.MaterialsCostItemVo;

@Service(value = "materialsCostItemService")
public class MaterialsCostItemServiceImpl implements MaterialsCostItemService {
    @Autowired
    private MaterialsCostItemDao materialsCostItemDao;


    @Override
    public int insert(MaterialsCostItem materialsCostItem) {
        return materialsCostItemDao.insert(materialsCostItem);
    }

    @Override
    public void updateById(MaterialsCostItem materialsCostItem) {
    	materialsCostItemDao.updateById(materialsCostItem);
    }

    @Override
    public int count(MaterialsCostItemSearchVo materialsCostItemSearchVo) {
        return materialsCostItemDao.count(materialsCostItemSearchVo);
    }

    @Override
    public List<MaterialsCostItemVo> selectList(MaterialsCostItemSearchVo materialsCostItemSearchVo) {
        return materialsCostItemDao.selectList(materialsCostItemSearchVo);
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
    	materialsCostItemDao.deleteByIds(ids);
    }
    
    @Override
    @Transactional
    public void deleteByUserBaseIds(Long[] ids) {
    	materialsCostItemDao.deleteByUserBaseIds(ids);
    }

    @Override
    public List<MaterialsCostItemVo> selectAll() {
        return materialsCostItemDao.selectAll();
    }

    @Override
    public List<MaterialsCostItemVo> selectInfoByIds(Long[] ids) {
        return materialsCostItemDao.selectInfoByIds(ids);
    }
    
    @Override
    public List<MaterialsCostItemVo> searchInfo(MaterialsCostItemVo materialsCostItemVo){
    	return materialsCostItemDao.searchInfo(materialsCostItemVo);
    }

	@Override
	public ArrayList<MaterialsCostItemVo> selectByUserBaseId(Long userBaseId) {
		// TODO Auto-generated method stub
		return materialsCostItemDao.selectByUserBaseId(userBaseId);
	}
}
