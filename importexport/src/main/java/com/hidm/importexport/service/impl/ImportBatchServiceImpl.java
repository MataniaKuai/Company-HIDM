package com.hidm.importexport.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.importexport.dao.ImportBatchDao;
import com.hidm.importexport.dao.ImportItemDao;
import com.hidm.importexport.entity.ImportBatch;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.service.ImportBatchService;
import com.hidm.importexport.service.MaterialService;
import com.hidm.importexport.util.DateUtil;
import com.hidm.importexport.util.ExcelUtil;
import com.hidm.importexport.vo.ImportBatchSearchVo;
import com.hidm.importexport.vo.ImportBatchVo;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;

@Service(value = "importBatchService")
public class ImportBatchServiceImpl implements ImportBatchService {
    private static Logger log = Logger.getLogger(ImportBatchServiceImpl.class);
    
    @Autowired
    private ImportBatchDao importBatchDao;
    
    @Autowired
    private ImportItemDao importItemDao;
    
    @Autowired
    private MaterialService materialService;
    
    public int insert(ImportBatch importBatch) {
        return importBatchDao.insert(importBatch);
    }
    
    public void insertBatch(List<ImportBatch> importBatchs) {
        if (!CollectionUtils.isEmpty(importBatchs)) {
            importBatchDao.insertBatch(importBatchs);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void saveFileInfo(String fileName, String filePath, List<ImportBatch> batchs) {
        
    }
    
    public void updateById(ImportBatch importBatch) {
        importBatch.setUpdateTime(new Date());
        importBatchDao.updateById(importBatch);
    }
    
    public int count(ImportBatchSearchVo importBatch) {
        return importBatchDao.count(importBatch);
    }
    
    public List<ImportBatchVo> selectList(ImportBatchSearchVo importBatch) {
        return importBatchDao.selectList(importBatch);
    }
    
    public int countByImportIds(Long[] ids) {
        return importBatchDao.countByImportIds(ids);
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            importBatchDao.deleteByIds(ids);
        }
    }
    
    public List<ImportBatchVo> getBatchList(Long importId, String poNo, String poItem, String materialNo) {
        ImportBatch batch = new ImportBatch();
        batch.setImportId(importId);
        batch.setPoNo(poNo);
        batch.setPoItem(poItem);
        batch.setMaterialNo(materialNo);
        ImportBatchSearchVo batchSearchVo = new ImportBatchSearchVo();
        batchSearchVo.setImportBatch(batch);
        List<ImportBatchVo> importBatchs = importBatchDao.selectList(batchSearchVo);
        return importBatchs;
    }
    
    public BigDecimal calBatchQty(Long importId, String poNo, String poItem, String materialNo) {
        BigDecimal batchQty = new BigDecimal(0);
        List<ImportBatchVo> importBatchs = getBatchList(importId, poNo, poItem, materialNo);
        
        if (null != importBatchs) {
            for (ImportBatchVo importBatch : importBatchs) {
                BigDecimal qty = importBatch.getQty();
                if (null != qty) {
                    batchQty = batchQty.add(qty);
                }
            }
        }
        
        return batchQty;
    }
    
    public List<ImportItemVo> checkQty(Long importId, List<Long> itemIds) {
        List<ImportItemVo> result = new ArrayList<ImportItemVo>();
        
        ImportItemSearchVo itemSearchVo = new ImportItemSearchVo();
        ImportItem importItem = new ImportItem();
        importItem.setImportId(importId);
        itemSearchVo.setImportItem(importItem);
        List<ImportItemVo> importItems = importItemDao.selectList(itemSearchVo);
        for (ImportItemVo item : importItems) {
            if (!itemIds.contains(item.getId())) {
                continue;
            }
            BigDecimal itemQty = item.getQty();
            if (null == itemQty) {
                item.setQty(ExcelUtil.bigDecimalFormat("0"));
                item.setBatchQty(ExcelUtil.bigDecimalFormat("0"));
                result.add(item);
                
                continue;
            }
            
            BigDecimal batchQty = calBatchQty(importId, item.getPoNo(), item.getPoItem(), item.getMaterialNo());
            
            if (!itemQty.equals(batchQty)) {
                item.setBatchQty(batchQty);
                result.add(item);
            }
        }
        
        return result;
    }
    
    public List<ImportBatchVo> checkOverdue(Long importId, List<Long> itemIds) {
        List<ImportBatchVo> result = new ArrayList<ImportBatchVo>();
        
        ImportItemSearchVo itemSearchVo = new ImportItemSearchVo();
        ImportItem importItem = new ImportItem();
        importItem.setImportId(importId);
        itemSearchVo.setImportItem(importItem);
        List<ImportItemVo> importItems = importItemDao.selectList(itemSearchVo);
        for (ImportItemVo item : importItems) {
            if (!itemIds.contains(item.getId())) {
                continue;
            }
            
            List<ImportBatchVo> importBatchs = getBatchList(importId, item.getPoNo(), item.getPoItem(), item.getMaterialNo());
            
            if (null != importBatchs) {
                for (ImportBatchVo importBatch : importBatchs) {
                    String materialNo = importBatch.getMaterialNo();
                    Date productTime = importBatch.getProduceTime();
                    
                    Date overdueTime = materialService.getOverdueDate(materialNo, productTime);
                    overdueTime = DateUtil.parseDate(DateUtil.formatDate(overdueTime));
                    Date now = new Date();
                    now = DateUtil.parseDate(DateUtil.formatDate(now));
                    
                    if (now.compareTo(overdueTime) >= 0) {
                        importBatch.setOverdueTime(overdueTime);
                        result.add(importBatch);
                    }
                }
            }
        }
        
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteImportBatchByIrNo(String irNo) {
        importBatchDao.deleteImportBatchByIrNo(irNo);
    }
}
