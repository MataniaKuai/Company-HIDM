package com.hidm.coo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.MFGBaseDao;
import com.hidm.coo.entity.EQtype;
import com.hidm.coo.entity.MFGBase;
import com.hidm.coo.service.MFGBaseService;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.service.UserBaseService;
import com.hidm.coo.service.VendorService;
import com.hidm.coo.util.SAPConn;
import com.hidm.coo.vo.MFGBaseSearchVo;
import com.hidm.coo.vo.MFGBaseVo;
import com.hidm.coo.vo.ModelVo;
import com.hidm.coo.vo.UserBaseVo;
import com.hidm.coo.vo.VendorVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "mfgBaseService")
public class MFGBaseServiceImpl implements MFGBaseService {
	private static Logger log = Logger.getLogger(MFGBaseServiceImpl.class);
    @Autowired
    private MFGBaseDao mfgBaseDao;
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
    public int insert(MFGBase mfgBase) {
        return mfgBaseDao.insert(mfgBase);
    }

    @Override
    public void updateById(MFGBase mfgBase) {
        mfgBaseDao.updateById(mfgBase);
    }

    @Override
    public int count(MFGBaseSearchVo mfgBaseVO) {
        return mfgBaseDao.count(mfgBaseVO);
    }

    @Override
    public List<MFGBaseVo> selectList(MFGBaseSearchVo mfgBaseVO) {
        return mfgBaseDao.selectList(mfgBaseVO);
    }

    @Override
    @Transactional
    public void deleteByIds(Long[] ids) {
        mfgBaseDao.deleteByIds(ids);
    }

    @Override
    public List<MFGBaseVo> selectAll() {
        return mfgBaseDao.selectAll();
    }

    @Override
    public List<MFGBaseVo> selectInfoByIds(Long[] ids) {
        return mfgBaseDao.selectInfoByIds(ids);
    }
    
    @Override
    @Transactional
    public void deleteByUserBaseIds(Long[] ids) {
    	mfgBaseDao.deleteByUserBaseIds(ids);
    }
    
    @Override
    @Transactional
    public MFGBase synchToSap(MFGBase mfgBase) {
    	  boolean success = false;
          JCoFunction function = null;
          JCoDestination destination = sapConService.connect();                                                                                                                                              
          JCoTable table = null;        
          try {
          	 boolean hasData = false;
               function = destination.getRepository().getFunction("ZCOO_JAVATOSAP_004");        
               JCoParameterList input = function.getImportParameterList();
//               EQtype eqType = new EQtype();
//               eqType.setEqType(mfgBase.getEqTypeId());
//               EQtypeSearchVo eqTypeSearchVo = new EQtypeSearchVo();
//               List<EQtypeVo> eqTypeList = eqTypeService.selectList(eqTypeSearchVo);        
               Long[] baseId = new Long[1];
               baseId[0] = mfgBase.getUserBaseId();
               List<UserBaseVo> userVoList = userBaseService.selectInfoByIds(baseId);
               
               VendorVo vendorVo = vendorService.selectByName(userVoList.get(0).getVendor());
               ModelVo modelVo = modelService.selectByName(userVoList.get(0).getModel());
               
               hasData = true;
               input.setValue("IV_EQTYPEID", userVoList.get(0).getEqTypeId());
               input.setValue("IV_EQTYPE", userVoList.get(0).getEqTypeId());
               input.setValue("IV_MODULE", userVoList.get(0).getModule());
               input.setValue("IV_VENDORID", vendorVo.getVendorNo());
               input.setValue("IV_VENDOR", userVoList.get(0).getVendor());
               input.setValue("IV_MODELID", modelVo.getModelNo());
               input.setValue("IV_MODEL", userVoList.get(0).getModel());
               input.setValue("IV_MFGMANMACHINE", userVoList.get(0).getManMachine());
               input.setValue("IV_MFGSHIFT", userVoList.get(0).getShift());                  
               if(hasData) {
              	 log.info("begin to call SAP to mfgbase." + input.toXML());
                   function.execute(destination);
                   table = function.getTableParameterList().getTable("T_MESSAGE");
                   log.info("finish to call SAP to mfgbase description. T_MESSAGE: " + table.toXML());
                   table.firstRow();
                   String sapError = "";
                   for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                       String ok = table.getString("ZIS_OK");
                       if ("S".equals(ok)) {
                           success = true;
                           
                       } else {
                           String message = table.getString("MSG");
                           sapError = sapError + "[" + message + "]";
                           log.error("Fail to mfgbase. ok:" + ok + ", message:" + message);
                       }
                   }
               } else {
              	 log.error("Fail to mfgbase, no data." );
               }
          	
          } catch(Exception e) {
          	log.error("Failed to mfgbase. success: " + success, e);
            throw new RuntimeException(e);
          }              
    	return mfgBase;
    }
    
    @Override
    @Transactional
	 public MFGBase synchToSap2(MFGBase mfgBase) {
	    	 boolean success = false;
	         JCoFunction function = null;
	         JCoDestination destination = sapConService.connect();
	         String ex_olCost;
	         JCoTable table = null;        
	         try {
	         	 boolean hasData = false;
	              function = destination.getRepository().getFunction("ZCOO_JAVATOSAP_005");        
	              JCoParameterList input = function.getImportParameterList();
	              EQtype eqType = new EQtype();
	              eqType.setEqType(mfgBase.getEqTypeId());
	              hasData = true;
                  VendorVo vendorVo = vendorService.selectByName(mfgBase.getVendor());
                  ModelVo modelVo = modelService.selectByName(mfgBase.getModel());
	              input.setValue("IV_EQTYPEID", mfgBase.getEqTypeId());
	              input.setValue("IV_EQTYPE", mfgBase.getEqTypeId());
	              input.setValue("IV_MODULE", mfgBase.getModule());
	              input.setValue("IV_VENDORID", vendorVo.getVendorNo());
	              input.setValue("IV_VENDOR", mfgBase.getVendor());
	              input.setValue("IV_MODELID", modelVo.getModelNo());
	              input.setValue("IV_MODEL", mfgBase.getModel());
	              input.setValue("IV_OLSALARY", mfgBase.getOperateLaborSalary());
	              input.setValue("IV_MLSALARY", mfgBase.getMaintainLaborSalary()); 
	              input.setValue("IV_FLOORCOST1", mfgBase.getFloorCost());  
	              input.setValue("IV_FLOORCOST2", mfgBase.getFloorCostAcount());                  
	              if(hasData) {
	             	 log.info("begin to call SAP to mfgbase. " + input.toXML());
	                 function.execute(destination);
	                  table = function.getTableParameterList().getTable("T_MESSAGE");
	                  log.info("finish to call SAP to get mfgbase description. T_MESSAGE: " + table.toXML());
	                  table.firstRow();
	                  String sapError = "";
	                  ex_olCost= function.getExportParameterList().getString("EX_OLCOST");
	                  mfgBase.setOperateLaborCost(ex_olCost);
	                  log.info("ex_olCost::" + ex_olCost); 
	                  for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
	                      String ok = table.getString("ZIS_OK");
	                      if ("S".equals(ok)) {
	                          success = true;                          
	                        
	                      } else {
	                          String message = table.getString("MSG");
	                          sapError = sapError + "[" + message + "]";
	                          log.error("Fail to mfgbase. ok:" + ok + ", message:" + message);
	                      }
	                  }
	              } else {
	             	 log.error("Fail to mfgbase, no data. " );
	              }
	         	
	         } catch(Exception e) {
	         	log.error("Failed to mfgbase. success: " + success, e);
	            throw new RuntimeException(e);
	         }              
	    
	    	return mfgBase;    
	    }

    @Override
    public List<MFGBase> selectByUserId(Long id) {
        return mfgBaseDao.selectByUserId(id);
    }
}
