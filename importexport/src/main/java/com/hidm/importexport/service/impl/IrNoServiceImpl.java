package com.hidm.importexport.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.importexport.dao.IrNoDao;
import com.hidm.importexport.entity.IrNo;
import com.hidm.importexport.service.IrNoService;

@Service(value = "irNoService")
public class IrNoServiceImpl implements IrNoService {
    @Autowired
    private IrNoDao irNoDao;
    
    public int insert(IrNo irNo) {
        return irNoDao.insert(irNo);
    }
    
    public void updateById(IrNo irNo) {
        irNo.setUpdateTime(new Date());
        irNoDao.updateById(irNo);
    }
    
    public List<IrNo> selectList(IrNo irNo) {
        return irNoDao.selectList(irNo);
    }
    
    public List<IrNo> selectForUpate(IrNo irNo) {
        return irNoDao.selectForUpate(irNo);
    }
    
    public void deleteByIds(Long[] ids) {
        irNoDao.deleteByIds(ids);
    }
    
    public void deleteByYears(Long[] years) {
        irNoDao.deleteByYears(years);
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int generateSeqNo(int year, String org) {
        int seqNo = 1;
        IrNo irNo = new IrNo();
        irNo.setYearNo(year);
        irNo.setOrg(org);
        
        List<IrNo> list = irNoDao.selectForUpate(irNo);
        if (CollectionUtils.isEmpty(list)) {
            irNo.setSeqNo(seqNo);
            irNoDao.insert(irNo);
        } else {
            irNo = list.get(0);
            seqNo = irNo.getSeqNo() + 1;
            irNo.setSeqNo(seqNo);
            irNoDao.updateById(irNo);
        }
        
        return seqNo;
    }
}
