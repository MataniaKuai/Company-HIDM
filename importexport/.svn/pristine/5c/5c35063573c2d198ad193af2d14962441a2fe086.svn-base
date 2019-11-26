package com.hidm.importexport.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hidm.importexport.constant.BusinessConstant;
import com.hidm.importexport.dao.ImportItemDao;
import com.hidm.importexport.entity.ImportItem;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.service.ImportItemService;
import com.hidm.importexport.service.UserService;
import com.hidm.importexport.util.SAPConn;
import com.hidm.importexport.vo.ImportItemSearchVo;
import com.hidm.importexport.vo.ImportItemVo;
import com.hidm.importexport.vo.PortalUserVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "importItemService")
public class ImportItemServiceImpl implements ImportItemService {
    private static Logger log = Logger.getLogger(ImportItemServiceImpl.class);
    
    @Autowired
    private ImportItemDao importItemDao;
    
    @Autowired
    private UserService portalUserService;
    
    @Autowired
    private SAPConn sapConService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    public int insert(ImportItem importItem) {
        return importItemDao.insert(importItem);
    }
    
    public void insertBatch(List<ImportItem> importItems) {
        try {
            if (!CollectionUtils.isEmpty(importItems)) {
                importItemDao.insertBatch(importItems);
                for (ImportItem importItem : importItems) {
                    //向操作历史表中插入记录
                    businessHisService.insert(String.valueOf(importItem.getId()), importItem.getPoNo()+importItem.getPoItem(), 
                            BusinessConstant.BUSINESS_TYPE_ITEM, BusinessConstant.BUSINESS_INSERT, importItem);
                }
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. importItems：" + importItems, e);
        }
    }
    
    public List<ImportItemVo> selectListByGrNo(ImportItemSearchVo vo) {
        return importItemDao.selectListByGrNo(vo);
    }
    
    public int sync(String poNo, Long importId) {
        if (null == importId || 0 == importId.intValue() || StringUtils.isEmpty(poNo)) {
            return 0;
        }
        
        int rows = 0;
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZMM_SAPTOIAE_001");
            JCoParameterList input = function.getImportParameterList();

            input.setValue("IV_EBELN", poNo);
            
            //连接SAP接口之前 打印input中的信息
            log.info("begin to call SAP to sync PO info." + input.toXML());
            
            function.execute(destination);
            table = function.getTableParameterList().getTable("T_DATA");
            //连接SAP接口成功后 打印table信息
            log.info("Success to call SAP to sync PO info. " + table.toXML());

            rows = table.getNumRows();
            log.info("table rows:" + rows);
            
            List<ImportItem> importItems = new ArrayList<ImportItem>();
            
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
                ImportItem importItem = new ImportItem();
                if (!StringUtils.isEmpty(poNo)) {
                    importItem.setPoNo(poNo.trim());
                }
                importItem.setImportId(importId);
                
                String poItem = table.getString("EBELP");
                if (!StringUtils.isEmpty(poItem)) {
                    poItem = new Integer(poItem).toString();
                }
                importItem.setPoItem(poItem);
                String vendor = table.getString("LIFNR");
                importItem.setVendor(vendor);
                String materialNo = table.getString("MATNR");
                importItem.setMaterialNo(materialNo);
                String goodsDesc = table.getString("TXZ01");
                importItem.setGoodsDesc(goodsDesc);
                String unit = table.getString("MEINS");
                importItem.setUnit(unit);
                BigDecimal qty = table.getBigDecimal("MENGE");
                importItem.setQty(qty);
                String tradeTerm = table.getString("ZTERM");
                importItem.setTradeTerm(tradeTerm);
                String currency = table.getString("WAERS");
                importItem.setCurrency(currency);
                String assetNo = table.getString("ANLN1");
                importItem.setAssetNo(assetNo);
                String childAssetNo = table.getString("ANLN2");
                importItem.setChildAssetNo(childAssetNo);
                String employeeNo = table.getString("AFNAM");
                importItem.setEmployeeNo(employeeNo);
                String dept = table.getString("ATWRT");
                if (StringUtils.isEmpty(dept)) {
                    if (!StringUtils.isEmpty(employeeNo)) {
                        PortalUserVo userVo = portalUserService.getUserInfoByEmployeeNo(employeeNo);
                        if (null != userVo) {
                            dept = userVo.getEdepartment();
                        } else {
                            log.error("deptVo is null. employeeNo:" + employeeNo + ", poNo:" + poNo + ", poItem:" + poItem);
                        }
                    } else {
                        log.error("employeeNo is null. poNo:" + poNo + ", poItem:" + poItem);
                    }
                }
                importItem.setDept(dept);
                String stock = table.getString("LGORT");
                importItem.setStock(stock);
                String isBatch = table.getString("XCHPF");
                if ("X".equals(isBatch.trim())) {
                    importItem.setIsBatch(1);
                } else {
                    importItem.setIsBatch(0);
                }
                importItems.add(importItem);
            }
            insertBatch(importItems);
        } catch (Exception e) {
            log.error("Failed to sync.", e);
        }
        
        return rows;
    }
    
    public void updateById(ImportItem importItem) {
        importItem.setUpdateTime(new Date());
        importItemDao.updateById(importItem);
    }
    
    public int count(ImportItemSearchVo importItem) {
        return importItemDao.count(importItem);
    }
    
    public List<ImportItemVo> selectList(ImportItemSearchVo importItem) {
        return importItemDao.selectList(importItem);
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            importItemDao.deleteByIds(ids);
        }
    }
    
    public void unReceiveByIds(Long[] ids) {
        importItemDao.unReceiveByIds(ids);
    }
    
    public int countUnReceived(ImportItemSearchVo importItem) {
        return importItemDao.countUnReceived(importItem);
    }
    
    public int countReceived(ImportItemSearchVo importItem) {
        return importItemDao.countReceived(importItem);
    }

    @Override
    public int selectCountByGrNo(ImportItemSearchVo vo) {
        return importItemDao.selectCountByGrNo(vo);
    }

    @Override
    public List<ImportItemVo> selectByIds(Long[] itemIds) {
        List<ImportItemVo> itemList = importItemDao.selectByIds(itemIds);
        return itemList;
    }

    @Override
    public void insertItems(List<ImportItem> items) {
        if (!CollectionUtils.isEmpty(items)) {
            importItemDao.insertItems(items);
        }
    }

    @Override
    public List<ImportItemVo> selectImportItemByIds(Long[] ids) {
        return importItemDao.selectByIds(ids);
    }

}
