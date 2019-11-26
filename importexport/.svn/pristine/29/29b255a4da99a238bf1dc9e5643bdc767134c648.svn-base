package com.hidm.importexport.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hidm.importexport.constant.FileConstant;
import com.hidm.importexport.dao.FileInfoDao;
import com.hidm.importexport.dao.MaterialDao;
import com.hidm.importexport.entity.FileInfo;
import com.hidm.importexport.entity.Material;
import com.hidm.importexport.service.MaterialService;
import com.hidm.importexport.util.SAPConn;
import com.hidm.importexport.vo.MaterialSearchVo;
import com.hidm.importexport.vo.MaterialVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "materialService")
public class MaterialServiceImpl implements MaterialService {
    private static Logger log = Logger.getLogger(MaterialServiceImpl.class);
    
    @Autowired
    private MaterialDao materialDao;
    
    @Autowired
    private FileInfoDao fileInfoDao;

    @Autowired
    private SAPConn sapConService;
    
    public int insert(Material material) {
        return materialDao.insert(material);
    }
    
    public void updateById(Material material) {
        material.setUpdateTime(new Date());
        materialDao.updateById(material);
    }
    
    public int count(MaterialSearchVo material) {
        return materialDao.count(material);
    }
    
    public List<MaterialVo> selectList(MaterialSearchVo material) {
        return materialDao.selectList(material);
    }
    
    public List<MaterialVo> selectExport(MaterialSearchVo material) {
        return materialDao.selectExport(material);
    }
    
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            materialDao.deleteByIds(ids);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void savePhotoInfo(String fileName, String filePath, Long materialId) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFilePath(filePath);
        fileInfo.setFileType(FileConstant.TYPE_MATERIAL);
        fileInfoDao.insert(fileInfo);
        
        Material material = new Material();
        material.setId(materialId);
        material.setFileId(fileInfo.getId());
        updateById(material);
    }
    
    public Date getOverdueDate(String materialNo, Date productTime) {
        if (null == productTime && StringUtils.isEmpty(materialNo)) {
            return null;
        }
        
        int period = 0;
        String unit = null;
        
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZMM_SAPTOIAE_007");
            JCoParameterList input = function.getImportParameterList();

            input.setValue("I_MATNR", materialNo);
            
            //连接SAP接口前，先打印input信息
            log.info("begin to call SAP to get overdue date." + input.toXML());
            
            function.execute(destination);
            
            boolean success = false;
            table = function.getTableParameterList().getTable("T_MESSAGE");
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
                String ok = table.getString("ZIS_OK");
                if ("S".equals(ok)) {
                    success = true;
                } else {
                    String message = table.getString("MSG");
                    log.error("Fail to get overdue date. ok:" + ok + ", message:" + message);
                }
            }
            
            if (success) {
                table = function.getTableParameterList().getTable("T_DATA");
                //连接成功后把从sap获取的table信息打印出来
                log.info("Success to call SAP to get overdue date"  + table.toXML());
                table.firstRow();
                for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                    period = table.getInt("MHDHB");
                    unit = table.getString("IPRKZ");

                    log.info("period:" + period + ", unit:" + unit);
                }
            }
        } catch (Exception e) {
            log.error("Failed to getOverdueDate.", e);
        }
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(productTime);
        
        if (period > 0) {
            if ("D".equals(unit)) {
                cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR) + period);
            } else if ("M".equals(unit)) {
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + period);
            } else if ("W".equals(unit)) {
                cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR) + period);
            } else if ("Y".equals(unit)) {
                cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + period);
            }
        }

        Date overdueDate = cal.getTime();
        return overdueDate;
    }

    @Override
    public String getDecription(String materialNo) {
        if (StringUtils.isEmpty(materialNo)) {
            return null;
        }
        
        String description = "";
        
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZMM_SAPTOIAE_010");
            JCoParameterList input = function.getImportParameterList();
            input.setValue("IV_MATNR", materialNo);
            //连接SAP接口前，先打印input信息
            log.info("begin to call SAP to get material description." + input.toXML());
            function.execute(destination);
            
            boolean success = false;
            table = function.getTableParameterList().getTable("T_MESSAGE");
            //连接SAP接口成功后，打印table信息
            log.info("Success to call SAP to get material description." + table.toXML());
            
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
                String ok = table.getString("ZIS_OK");
                if ("S".equals(ok)) {
                    success = true;
                } else {
                    String message = table.getString("MSG");
                    log.error("ok:" + ok + ", message:" + message);
                }
            }
            
            if (success) {
                table = function.getTableParameterList().getTable("T_DATA");
                table.firstRow();
                for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                    //description = table.getString("ZMKTX");//英文描述
                    description = table.getString("MAKTX");//中文描述

                    log.info("description:" + description);
                }
            }
        } catch (Exception e) {
            log.error("Failed to getDecription.", e);
        }
        return description;
    }
    
    public static void main(String[] args) {
        MaterialServiceImpl a = new MaterialServiceImpl();
        a.getOverdueDate("c000001", new Date());
        a.getDecription("C000006");
    }

    @Override
    public List<Material> selectMaterialByIds(Long[] ids) {
        return materialDao.selectMaterialByIds(ids);
    }
}
