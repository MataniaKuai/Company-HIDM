package com.hidm.importexport.service.impl;

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
import com.hidm.importexport.dao.AssetDao;
import com.hidm.importexport.dao.FileInfoDao;
import com.hidm.importexport.entity.Asset;
import com.hidm.importexport.entity.FileInfo;
import com.hidm.importexport.service.AssetService;
import com.hidm.importexport.util.SAPConn;
import com.hidm.importexport.vo.AssetSearchVo;
import com.hidm.importexport.vo.AssetVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "assetService")
public class AssetServiceImpl implements AssetService {
    private static Logger log = Logger.getLogger(AssetServiceImpl.class);
    @Autowired
    private AssetDao assetDao;
    
    @Autowired
    private FileInfoDao fileInfoDao;

    @Autowired
    private SAPConn sapConService;
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int insert(Asset asset) {
        return assetDao.insert(asset);
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void updateById(Asset asset) {
        asset.setUpdateTime(new Date());
        assetDao.updateById(asset);
    }
    
    public int count(AssetSearchVo asset) {
        return assetDao.count(asset);
    }
    
    public List<AssetVo> selectList(AssetSearchVo asset) {
        return assetDao.selectList(asset);
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void deleteByIds(Long[] ids) {
        if (null != ids && ids.length > 0) {
            assetDao.deleteByIds(ids);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void savePhotoInfo(String fileName, String filePath, Long assetId) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFilePath(filePath);
        fileInfo.setFileType(FileConstant.TYPE_ASSET);
        fileInfoDao.insert(fileInfo);
        
        Asset asset = new Asset();
        asset.setId(assetId);
        asset.setFileId(fileInfo.getId());
        updateById(asset);
    }

    @Override
    public List<AssetVo> selectExport(AssetSearchVo vo) {
        return assetDao.selectExport(vo);
    }

    @Override
    public String getDecription(String assetNo) {
    	String mainAssetNo = "";
    	String childAssetNo = "";
        if (StringUtils.isEmpty(assetNo)) {
            return null;
        }
        String []temp = assetNo.split("-");
        if(temp.length ==2) {
	        mainAssetNo = temp[0];
	        childAssetNo = temp[1];
        }
        
        String description = "";
        
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZMM_SAPTOIAE_011");
            JCoParameterList input = function.getImportParameterList();

            input.setValue("IV_BUKRS", "1000");
            input.setValue("IV_ANLN1", mainAssetNo);
            input.setValue("IV_ANLN2", childAssetNo);
            
            //连接SAP接口前，先打印input的信息
            log.info("begin to call SAP to get asset description." + input.toXML());
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
                    log.error("ok:" + ok + ", message:" + message);
                }
            }
            
            if (success) {
                table = function.getTableParameterList().getTable("T_DATA");
                
                //连接SAP接口成功后，显示table信息
                log.info("success to call SAP to get asset description." + table.toXML());
                
                table.firstRow();
                for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                    description = table.getString("TXT50");

                    log.info("assetNo:"+assetNo+"---description:" + description);
                }
            }
        } catch (Exception e) {
            log.error("Failed to getDecription.", e);
        }
        return description;
    }
    public static void main(String[] args) {
        AssetServiceImpl impl = new AssetServiceImpl();
        for (int i=0; i<10; i++) {
            impl.getDecription("00120000000"+i);
        }
    }

    @Override
    public List<Asset> selectAssetByIds(Long[] ids) {
        return assetDao.selectAssetByIds(ids);
    }
}
