package com.hidm.coo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.PROBaseDao;
import com.hidm.coo.entity.PROBase;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.service.PROBaseService;
import com.hidm.coo.service.UserBaseService;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.util.SAPConn;
import com.hidm.coo.vo.ModelVo;
import com.hidm.coo.vo.PROBaseSearchVo;
import com.hidm.coo.vo.PROBaseVo;
import com.hidm.coo.vo.UserBaseVo;
import com.hidm.coo.vo.VendorVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "proBaseService")
public class PROBaseServiceImpl implements PROBaseService {
	private static Logger log = Logger.getLogger(PROBaseServiceImpl.class);
	
    @Autowired
    private PROBaseDao proBaseDao;
    @Autowired
    private SAPConn sapConService;
    
    @Autowired
    private UserBaseService userBaseService;

    @Autowired
    private VendorService vendorService;
    
    @Autowired
    private ModelService modelService;
    
    @Override
    @Transactional
    public int insert(PROBase proBase) {
        return proBaseDao.insert(proBase);
    }

    @Override
    public void updateById(PROBase proBase) {
        proBaseDao.updateById(proBase);
    }

    @Override
    public int count(PROBaseSearchVo proBaseVO) {
        return proBaseDao.count(proBaseVO);
    }

    @Override
    public List<PROBaseVo> selectList(PROBaseSearchVo proBaseVO) {
        return proBaseDao.selectList(proBaseVO);
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        proBaseDao.deleteByIds(ids);
    }
    @Override
    @Transactional
    public void deleteByUserBaseIds(Long[] ids) {
    	proBaseDao.deleteByUserBaseIds(ids);
    };

    @Override
    public List<PROBaseVo> selectAll() {
        return proBaseDao.selectAll();
    }

    @Override
    public List<PROBaseVo> selectInfoByIds(Long[] ids) {
        return proBaseDao.selectInfoByIds(ids);
    }
       
    @Override
    @Transactional
    public PROBase synchToSap(PROBase proBase) {  
        boolean success = false;
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;        
        try {
        	 boolean hasData = false;
             function = destination.getRepository().getFunction("ZCOO_JAVATOSAP_002");
//             JCoParameterList input = function.getTableParameterList();
//             JCoTable t = input.getTable("T_DATA");             
             JCoParameterList input = function.getImportParameterList();
//             EQtype eqType = new EQtype();
//             eqType.setEqType(proBase.getEqTypeId());
//             EQtypeSearchVo eqTypeSearchVo = new EQtypeSearchVo();
//             List<EQtypeVo> eqTypeList = eqTypeService.selectList(eqTypeSearchVo);   
             Long[] baseId = new Long[1];
             baseId[0] = proBase.getUserBaseId();
             List<UserBaseVo> userVoList = userBaseService.selectInfoByIds(baseId);
             hasData = true;
             VendorVo vendorVo = vendorService.selectByName(proBase.getVendor());
             ModelVo modelVo = modelService.selectByName(proBase.getModel());
             
             input.setValue("IV_EQTYPEID", userVoList.get(0).getEqTypeId());
             input.setValue("IV_EQTYPE", userVoList.get(0).getEqTypeId());
             input.setValue("IV_MODULE", proBase.getModule());
             input.setValue("IV_VENDORID", vendorVo.getVendorNo());
             input.setValue("IV_VENDOR", proBase.getVendor());
             input.setValue("IV_MODELID", modelVo.getModelNo());
             input.setValue("IV_MODEL", proBase.getModel());
             input.setValue("IV_PURCHASEPRICE", proBase.getPurchasePrice());
             input.setValue("IV_TAX", proBase.getTax());
             input.setValue("IV_TRAININGCOST", proBase.getTrainingCost());
             input.setValue("IV_MAINSERVICECOST", proBase.getMainServiceCost());
             input.setValue("IV_ADDITIONALCOST", proBase.getAdditionalCost());    
             if(hasData) {
            	 log.info("begin to call SAP to probase. " + input.toXML());
                 function.execute(destination);
                 table = function.getTableParameterList().getTable("T_MESSAGE");
                 log.info("finish to call SAP to probase description. T_MESSAGE: " + table.toXML());
                 table.firstRow();
                 String sapError = "";
                 for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                     String ok = table.getString("ZIS_OK");
                     if ("S".equals(ok)) {
                         success = true;
                         
                     } else {
                         String message = table.getString("MSG");
                         sapError = sapError + "[" + message + "]";
                         log.error("Fail to probase. ok:" + ok + ", message:" + message);
                     }
                 }
             } else {
            	 log.error("Fail to probase, no data." );
             }
        	
        } catch(Exception e) {
        	log.error("Failed to probase. success: " + success, e);
            throw new RuntimeException(e);
        }        
    	return proBase;
    }

    @Override
    public List<PROBase> selectByUserId(Long id) {
        return proBaseDao.selectByUserId(id);
    }
}
