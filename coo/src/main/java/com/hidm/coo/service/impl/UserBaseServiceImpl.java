package com.hidm.coo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.UserBaseDao;
import com.hidm.coo.entity.EQtype;
import com.hidm.coo.entity.Others;
import com.hidm.coo.entity.UserBase;
import com.hidm.coo.service.MaterialCoefficientService;
import com.hidm.coo.service.MaterialsCostItemService;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.service.OthersService;
import com.hidm.coo.service.UserBaseService;
import com.hidm.coo.service.UtilityCostItemService;
import com.hidm.coo.service.UtilityService;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.util.RestUtil;
import com.hidm.coo.util.SAPConn;
import com.hidm.coo.vo.MaterialCoefficientVo;
import com.hidm.coo.vo.MaterialsCostItemVo;
import com.hidm.coo.vo.ModelVo;
import com.hidm.coo.vo.UserBaseSearchVo;
import com.hidm.coo.vo.UserBaseVo;
import com.hidm.coo.vo.UtilityCostItemVo;
import com.hidm.coo.vo.UtilityVo;
import com.hidm.coo.vo.VendorVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "userBaseService")
public class UserBaseServiceImpl implements UserBaseService {
	
	 private static Logger log = Logger.getLogger(UserBaseServiceImpl.class);
	
    @Autowired
    private UserBaseDao userBaseDao;
    
    @Autowired
    private SAPConn sapConService;
    
    @Autowired
    private UtilityCostItemService utilityCostItemService;
    
    @Autowired
    private UtilityService utilityService;
    
    @Autowired
    private MaterialsCostItemService materialsCostItemService;
    
    @Autowired
    private MaterialCoefficientService materialCoefficientService;

    @Autowired
    private VendorService vendorService;
    
    @Autowired
    private ModelService modelService;
    
    @Autowired
    private OthersService othersService;
    
    @Override
    @Transactional
    public int insert(UserBase userBase) {
        return userBaseDao.insert(userBase);
    }

    @Override
    @Transactional
    public void updateById(UserBase userBase) {
        userBaseDao.updateById(userBase);
    }

    @Override
    public int count(UserBaseSearchVo userBase) {
        return userBaseDao.count(userBase);
    }

    @Override
    public List<UserBaseVo> selectList(UserBaseSearchVo userBase) {
        return userBaseDao.selectList(userBase);
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        userBaseDao.deleteByIds(ids);
    }

    @Override
    public List<UserBaseVo> selectAll() {
        return userBaseDao.selectAll();
    }

    @Override
    public List<UserBaseVo> selectInfoByIds(Long[] ids) {
        return userBaseDao.selectInfoByIds(ids);
    }
    
    @Override
    @Transactional
    public UserBase synchToSap(UserBase userBase) {
        Others other=othersService.selectByName("Lifetime");
    	 boolean success = false;
         JCoFunction function = null;
         JCoDestination destination = sapConService.connect();
         JCoTable table = null;
         try {
        	 boolean hasData = false;
             function = destination.getRepository().getFunction("ZCOO_JAVATOSAP_001");
             JCoParameterList input = function.getTableParameterList();
             JCoTable t = input.getTable("T_HEADER");
             hasData = true;
             t.appendRow();
             t.setValue("EQTYPEID", userBase.getEqTypeId());
             t.setValue("EQTYPE", userBase.getEqTypeId());
             t.setValue("ZMODULE", userBase.getModule());
             
             VendorVo vendorVo = vendorService.selectByName(userBase.getVendor());
             ModelVo modelVo = modelService.selectByName(userBase.getModel());
             t.setValue("VENDORID", vendorVo.getVendorNo());
             t.setValue("VENDOR", userBase.getVendor());
             t.setValue("MODELID", modelVo.getModelNo());
             t.setValue("MODEL", userBase.getModel());
             t.setValue("LENGTH", Double.parseDouble(userBase.getLength()));
             t.setValue("WIDTH", Double.parseDouble(userBase.getWidth()));
             t.setValue("HOUSING", Double.parseDouble(userBase.getHousing()));
             t.setValue("MANMACHINE", Double.parseDouble(userBase.getManMachine()));
             t.setValue("SHIFT", userBase.getShift());
             t.setValue("UPH", userBase.getUph());
             if(userBase.getUptimeRate().length() > 0) {
                 t.setValue("UPTIMERATE", RestUtil.getRate(userBase.getUptimeRate()));
             }
             if(userBase.getReworkRate().length() > 0) {
                 t.setValue("REWORKRATE", RestUtil.getRate(userBase.getReworkRate()));
             }
             if(userBase.getScrapRate().length() > 0) {
                 t.setValue("SCRAPRATE", RestUtil.getRate(userBase.getScrapRate()));
             }
             t.setValue("INSTALLATIONCOST", Double.parseDouble(userBase.getInstallationCost()));
             t.setValue("HOOKUPCOST", Double.parseDouble(userBase.getHookupCost()));
             t.setValue("IHCOST", Double.parseDouble(userBase.getInstallationHookupCost()));
             t.setValue("QCOST", Double.parseDouble(userBase.getQualificationCost()));
             t.setValue("PARTSCOST", Double.parseDouble(userBase.getPartsCost()));
             t.setValue("LIFETIMEVALUE", other.getValue());
             
         
             UtilityCostItemVo utilityCostItemVo = new UtilityCostItemVo();
         	 utilityCostItemVo.setUserBaseId(userBase.getId());
         	 List<UtilityCostItemVo> searchUtilityInfo = utilityCostItemService.selectInfo(utilityCostItemVo);
         	
             JCoTable itemUtility = input.getTable("T_ITEM_UTILITY_COST");
             for (int i=0; i<searchUtilityInfo.size(); i++) {
            	 itemUtility.appendRow();
            	 itemUtility.setValue("EQTYPEID", userBase.getEqTypeId());   
            	 itemUtility.setValue("EQTYPE", userBase.getEqTypeId());
            	 itemUtility.setValue("ZMODULE", userBase.getModule());
            	 itemUtility.setValue("VENDORID", vendorVo.getVendorNo());
            	 itemUtility.setValue("VENDOR", userBase.getVendor());
            	 itemUtility.setValue("MODELID", modelVo.getModelNo());
            	 itemUtility.setValue("MODEL", userBase.getModel());
            	 itemUtility.setValue("ITEMS", searchUtilityInfo.get(i).getItemNo());
            	 itemUtility.setValue("UTILITYNO", searchUtilityInfo.get(i).getUtility());
            	 itemUtility.setValue("UTILITYNAME", searchUtilityInfo.get(i).getUtilityName());
            	 itemUtility.setValue("USAGEBYYEAR", Double.parseDouble(searchUtilityInfo.get(i).getUsageByYear()));
            	 String utilityNo = searchUtilityInfo.get(i).getUtility();
            	 ArrayList<UtilityVo> utilityVo = utilityService.selectByUtilityNo(utilityNo);
            	 if(utilityVo.get(0).getUtilityPrice() != null && !utilityVo.get(0).getUtilityPrice().isEmpty()) {
            	     itemUtility.setValue("UTILITYPRICE", Double.parseDouble(utilityVo.get(0).getUtilityPrice()));
            	 }
            	 itemUtility.setValue("UTILITYCOEFFICIENT", Double.parseDouble(utilityVo.get(0).getCoefficient()));
             }
             
             JCoTable itemMaterials = input.getTable("T_ITEM_MATERIALS_COST");
             ArrayList<MaterialsCostItemVo> MaterialsCostItemVo =  materialsCostItemService.selectByUserBaseId(userBase.getId());
             for (MaterialsCostItemVo materualItem : MaterialsCostItemVo) {
            	 itemMaterials.appendRow();
            	 itemMaterials.setValue("EQTYPEID", userBase.getEqTypeId());   
            	 itemMaterials.setValue("EQTYPE", userBase.getEqTypeId());
            	 itemMaterials.setValue("ZMODULE", userBase.getModule());
            	 itemMaterials.setValue("VENDORID", vendorVo.getVendorNo());
            	 itemMaterials.setValue("VENDOR", userBase.getVendor());
            	 itemMaterials.setValue("MODELID", modelVo.getModelNo());
            	 itemMaterials.setValue("MODEL", userBase.getModel());
        	     itemMaterials.setValue("ITEMS", materualItem.getItemNo());
        	     itemMaterials.setValue("MATERNO", materualItem.getMaterialNo());
        	     itemMaterials.setValue("MATERNMAE", materualItem.getMaterialName());
        	     itemMaterials.setValue("USAGEBYKWAFER", materualItem.getUsageByYear());
        	     
        	     ArrayList<MaterialCoefficientVo> MaterialCoefficientVo = materialCoefficientService.selectByMaterialNo(materualItem.getMaterialNo());
        	     if(MaterialCoefficientVo.get(0).getCoefficient() != null && MaterialCoefficientVo.get(0).getCoefficient().length() > 0) {
        	         itemMaterials.setValue("COEFFICIENT", Double.parseDouble(MaterialCoefficientVo.get(0).getCoefficient()));
        	     }
                 if(MaterialCoefficientVo.get(0).getMaterialPrice() != null && MaterialCoefficientVo.get(0).getMaterialPrice().length() > 0) {
                     itemMaterials.setValue("MATERIALPRICE", Double.parseDouble(MaterialCoefficientVo.get(0).getMaterialPrice()));
                 }
                 if(userBase.getUptimeRate() != null && userBase.getUptimeRate().length() > 0) {
                     itemMaterials.setValue("UPTIMERATE", Double.parseDouble(RestUtil.getRate(userBase.getUptimeRate())));
                 }
             }

             
             if (hasData) {
            	 log.info("begin to call SAP to ZCOO_JAVATOSAP_001. " + input.toXML());
                 function.execute(destination);
                 table = function.getTableParameterList().getTable("T_MESSAGE");
                 log.info("finish to call SAP to ZCOO_JAVATOSAP_001. T_MESSAGE: " + table.toXML());
                 table.firstRow();
                 String sapError = "";
                 for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                     String ok = table.getString("ZIS_OK");
                     if ("S".equals(ok)) {
                         success = true;
                     } else {
                         String message = table.getString("MSG");
                         sapError = sapError + "[" + message + "] ";
                         log.error("Fail to connection. ok:" + ok + ", message:" + message);
                     }
                 }
             }
             
             if (success) {
            	 JCoParameterList exportParameterList = function.getExportParameterList();
                 log.info("Success to call SAP to ZCOO_JAVATOSAP_001. " + table.toXML());
                 //table.firstRow();
                 userBase.setTotalUtilityCost(exportParameterList.getString("EX_TOTALUTILITYCOST"));
                 log.info("EX_TOTALUTILITYCOST::" + exportParameterList.getString("EX_TOTALUTILITYCOST"));
            	 userBase.setTotalMaterialCost(exportParameterList.getString("EX_TOTALMATERIALCOST"));
            	 log.info("EX_TOTALMATERIALCOST::" + exportParameterList.getString("EX_TOTALMATERIALCOST"));
            	 userBaseDao.updateById(userBase);
            	 //ieBaseService.synchToSAP(userBase.getId());
             }
             
             
         } catch (Exception e) {
             log.error("Failed to connection. success: " + success, e);
             throw new RuntimeException(e);
         }
    	return userBase;
    }
    
    @Override
    public List<UserBaseVo> selectCheckData(UserBaseSearchVo vo) {
        return userBaseDao.selectCheckData(vo);
    }
    
    @Override
    @Transactional
	 public UserBase synchToSap2(UserBase userBase) {
	    	 boolean success = false;
	         JCoFunction function = null;
	         JCoDestination destination = sapConService.connect();
	         String ex_mlCost;
	         JCoTable table = null;        
	         try {
	         	 boolean hasData = false;
	              function = destination.getRepository().getFunction("ZCOO_JAVATOSAP_005");        
	              JCoParameterList input = function.getImportParameterList();
	              EQtype eqType = new EQtype();
	              eqType.setEqType(userBase.getEqTypeId());
	              hasData = true;
	              
	              VendorVo vendorVo = vendorService.selectByName(userBase.getVendor());
	              ModelVo modelVo = modelService.selectByName(userBase.getModel());
	              input.setValue("IV_EQTYPEID", userBase.getEqTypeId());
	              input.setValue("IV_EQTYPE", userBase.getEqTypeId());
	              input.setValue("IV_MODULE", userBase.getModule());
	              input.setValue("IV_VENDORID", vendorVo.getVendorNo());
	              input.setValue("IV_VENDOR", userBase.getVendor());
	              input.setValue("IV_MODELID", modelVo.getModelNo());
	              input.setValue("IV_MODEL", userBase.getModel());
	              input.setValue("IV_OLSALARY", userBase.getOperateLaborSalary());
	              input.setValue("IV_MLSALARY", userBase.getMaintainLaborSalary()); 
	              input.setValue("IV_FLOORCOST1", userBase.getFloorCost());  
	              input.setValue("IV_FLOORCOST2", userBase.getFloorCostAcount());                  
	              if(hasData) {
	             	 log.info("begin to call SAP to ZCOO_JAVATOSAP_005. " + input.toXML());
	                 function.execute(destination);
	                  table = function.getTableParameterList().getTable("T_MESSAGE");
	                  log.info("finish to call SAP to get userbase description. T_MESSAGE: " + table.toXML());
	                  table.firstRow();
	                  String sapError = "";
	                  ex_mlCost= function.getExportParameterList().getString("EX_MLCOST");
	                  userBase.setMaintainLaborCost(ex_mlCost);
	                  log.info("ex_mlCost::" + ex_mlCost); 
	                  for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
	                      String ok = table.getString("ZIS_OK");
	                      if ("S".equals(ok)) {
	                          success = true;                          
	                        
	                      } else {
	                          String message = table.getString("MSG");
	                          sapError = sapError + "[" + message + "]";
	                          log.error("Fail to userbase. ok:" + ok + ", message:" + message);
	                      }
	                  }
	              } else {
	             	 log.error("Fail to userbase, no data. " );
	              }
	         	
	         } catch(Exception e) {
	         	log.error("Failed to userbase. success: " + success, e);
	            throw new RuntimeException(e);
	         }              
	    
	    	return userBase;    
	    }

    @Override
    public int countMc(UserBaseSearchVo vo) {
        return userBaseDao.countMc(vo);
    }

    @Override
    public List<UserBaseVo> selectListMc(UserBaseSearchVo vo) {
        return userBaseDao.selectListMc(vo);
    }
}
