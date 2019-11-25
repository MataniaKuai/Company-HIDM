package com.hidm.importexport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.importexport.dao.InventoryDao;
import com.hidm.importexport.entity.Inventory;
import com.hidm.importexport.entity.InventoryResult;
import com.hidm.importexport.entity.MaterialType;
import com.hidm.importexport.service.InventoryService;
import com.hidm.importexport.service.SAPConn;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;


@Service(value = "InventoryService")
public class InventoryServiceImpl implements InventoryService {
    private static Logger log = Logger.getLogger(InventoryServiceImpl.class);
    @Autowired  
    private InventoryDao inventoryDao;
    
    @Autowired
    private SAPConn sapConService;
    
    @Value("${hisdata_days}")
    private String hisDataDays;

       
    //同步SAP库存消耗数据
    @Transactional
    public int sync() {
        int rows = 0;
        JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        log.info("===========start call to ZSIMM_002=============== ");
        try {
            function = destination.getRepository().getFunction("ZSIMM_002");
            
            function.execute(destination);
            table = function.getTableParameterList().getTable("T_DATA");
            //连接SAP接口成功后 打印table信息
            log.info("Success to call SAP to sync PO info. " + table.toXML());

            rows = table.getNumRows();
            log.info("table rows:" + rows);
            
            List<Inventory> inventoryConsumptions = new ArrayList<Inventory>();
            
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
            	Inventory mInventoryConsumption = new Inventory();
                String matnr = table.getString("MATNR");
                String maktx = table.getString("MAKTX");
                String matkl = table.getString("MATKL");
                String wgbez = table.getString("WGBEZ");
                String werks = table.getString("WERKS");
                String lgort = table.getString("LGORT");
                String bwart = table.getString("BWART");
                String z_bwart = table.getString("Z_BWART");
                String mblnr = table.getString("MBLNR");
                String mjahr = table.getString("MJAHR");
                String zeile = table.getString("ZEILE");
                String budat = table.getString("BUDAT");
                String erfmg = table.getString("ERFMG");
                String erfme = table.getString("ERFME");
                String bktxt_jck = table.getString("BKTXT_JCK");
                String ebeln = table.getString("EBELN");
                String ebelp = table.getString("EBELP");
                String mtart = table.getString("MTART");
                String xblnr = table.getString("XBLNR");
                String bktxt = table.getString("BKTXT");
                String name_text = table.getString("NAME_TEXT");
                String stprs = table.getString("STPRS");
                String verpr = table.getString("VERPR");
                String vprsv = table.getString("VPRSV");
                String waers = table.getString("WAERS");
                
                mInventoryConsumption.setMatnr(matnr);
                mInventoryConsumption.setMaktx(maktx);
                mInventoryConsumption.setMatkl(matkl);
                mInventoryConsumption.setWgbez(wgbez);
                mInventoryConsumption.setWerks(werks);
                mInventoryConsumption.setLgort(lgort);
                mInventoryConsumption.setBwart(bwart);
                mInventoryConsumption.setZ_bwart(z_bwart);
                mInventoryConsumption.setMblnr(mblnr);
                mInventoryConsumption.setMjahr(mjahr);
                mInventoryConsumption.setZeile(zeile);
                mInventoryConsumption.setBudat(budat);
                mInventoryConsumption.setErfmg(erfmg);
                mInventoryConsumption.setErfme(erfme);
                mInventoryConsumption.setBktxt_jck(bktxt_jck);
                mInventoryConsumption.setEbeln(ebeln);
                mInventoryConsumption.setEbelp(ebelp);
                mInventoryConsumption.setMtart(mtart);
                mInventoryConsumption.setXblnr(xblnr);
                mInventoryConsumption.setBktxt(bktxt);
                mInventoryConsumption.setName_text(name_text);
                mInventoryConsumption.setStprs(stprs);
                mInventoryConsumption.setVerpr(verpr);
                mInventoryConsumption.setVprsv(vprsv);
                mInventoryConsumption.setWaers(waers);
               
                inventoryConsumptions.add(mInventoryConsumption);
            }
            log.info("=========inventoryConsumptions.size()======= " +inventoryConsumptions.size());
            
            //分批插入数据库，每批500条
            int batchCount = 500;
            int index = 0;
            int size = inventoryConsumptions.size();
            if(size > 0) {
                while(true) {
                    if(index + batchCount >= size) {
                        insertInventory(inventoryConsumptions.subList(index, size));
                        insertInventoryHis(inventoryConsumptions.subList(index, size));
                        break;
                    }else {
                        insertInventory(inventoryConsumptions.subList(index, index+batchCount));
                        insertInventoryHis(inventoryConsumptions.subList(index, index+batchCount));
                        index = index+batchCount;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Failed to sync.", e);
            throw new RuntimeException(e);
        }
        
        return rows;
    }

    
    public void insertInventory(List<Inventory> inventoryConsumptions) {
    	inventoryDao.insertInventory(inventoryConsumptions);
    }


	public List<InventoryResult> countInventory(String date, String materialType) {
		// TODO Auto-generated method stub
		return inventoryDao.countInventory(date, materialType);
	}


	public List<MaterialType> getMaterialType() {
		return inventoryDao.getMaterialType();
	}


	public void insertInventoryHis(List<Inventory> inventoryConsumptions) {
		inventoryDao.insertInventoryHis(inventoryConsumptions);
		
	}

	@Transactional
	public void delInventoryHis() {
		inventoryDao.delInventoryHis(Integer.parseInt(hisDataDays)+1);
	}

	@Transactional
	public void delInventory() {
		inventoryDao.delInventory();
	}


    @Override
    public List<InventoryResult> selectInventory(InventoryResult inventoryResults) {
        return inventoryDao.selectInventory(inventoryResults);
    }
    @Override
    public List<InventoryResult> findByDateAndType(InventoryResult inventoryResults){
    	return inventoryDao.findByDateAndType(inventoryResults);
    }


	@Override
	public List<InventoryResult> selectMonInventory(InventoryResult inventoryResults) {
		 return inventoryDao.selectMonInventory(inventoryResults);
	}
}
