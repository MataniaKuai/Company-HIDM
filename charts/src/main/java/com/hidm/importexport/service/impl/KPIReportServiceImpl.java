package com.hidm.importexport.service.impl; 

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.importexport.dao.KPIReportDao;
import com.hidm.importexport.entity.KPIReport;
import com.hidm.importexport.entity.MaterialType;
import com.hidm.importexport.service.KPIReportService;
import com.hidm.importexport.service.SAPConn;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;
@Service(value = "KPIReportService")
public class KPIReportServiceImpl implements KPIReportService{
	private static Logger log = Logger.getLogger(AchievementsServiceImpl.class);
    @Autowired  
    private KPIReportDao kpireportDao;
	@Autowired
	private SAPConn sapConService;
    //同步SAP库存KPI数据
    @Transactional
	public int sync() { 
    	int rows = 0;
        try {
        	int curmonth = Calendar.getInstance().get(Calendar.MONTH)+1;		
        	int year = Calendar.getInstance().get(Calendar.YEAR);
        	for(int k=1;k<=curmonth;k++)
        	{
        		String month;
        		rows = 0;
                JCoFunction function = null;
                JCoDestination destination = sapConService.connect();
                JCoTable table = null;
                log.info("===========start call to ZSIMM_004=============== ");
        		if(k<10)
        			month="0"+k;
        		else month=k+"";
            function = destination.getRepository().getFunction("ZSIMM_004");
            JCoParameterList input = function.getImportParameterList();
            input.setValue("IV_YEAR", year);
			input.setValue("IV_MONTH",month);
            function.execute(destination);
            table = function.getTableParameterList().getTable("T_DATA");
            //连接SAP接口成功后 打印table信息
            log.info("Success to call SAP to sync PO info. " + table.toXML());

            rows = table.getNumRows();
            log.info("table rows:" + rows);
            
            List<KPIReport> kpireports = new ArrayList<KPIReport>();
            
            table.firstRow(); 
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
            	KPIReport kpireport=new KPIReport();
            	String matnr = table.getString("MATNR");
            	String werks = table.getString("WERKS");
            	String maktx = table.getString("MAKTX");
            	String lgort = table.getString("LGORT");
            	String lgpbe = table.getString("LGPBE");
            	String meins = table.getString("MEINS");
            	String matkl = table.getString("MATKL");
            	String zqty = table.getString("ZQTY");       
            	String zprice = table.getString("ZPRICE");
            	kpireport.setMatnr(matnr);
            	kpireport.setWerks(werks);
            	kpireport.setMaktx(maktx);
            	kpireport.setLgort(lgort);
            	kpireport.setLgpbe(lgpbe);
            	kpireport.setMeins(meins);
            	kpireport.setMatkl(matkl);
            	kpireport.setZqty(zqty);          
            	kpireport.setZprice(zprice);
            	kpireport.setMonthdate((year+month));;
            	kpireports.add(kpireport);
            }
    		rows = 0;
            JCoFunction function1 = null;
            JCoDestination destination1 = sapConService.connect();
            JCoTable table1 = null;
            log.info("===========start call to ZSIMM_004=============== ");
            function1 = destination1.getRepository().getFunction("ZSIMM_004");
            JCoParameterList input1 = function1.getImportParameterList();
            input1.setValue("IV_YEAR", year);
			input1.setValue("IV_MONTH",curmonth);
			function1.execute(destination1);
			table1 = function1.getTableParameterList().getTable("T_DATA");
			 table1.firstRow(); 
			 for (int i = 0; i < table1.getNumRows(); i++, table1.nextRow()) 
	            { 
				 KPIReport kpireport=kpireports.get(i);
				 String maktx = table1.getString("MAKTX");
				 if(maktx.equals(kpireport.getMaktx()))
				 {
				 String zprice = table1.getString("ZPRICE");
				 kpireport.setZprice(zprice);
				 }
	            }
            log.info("=========kpireport.size()======= " +kpireports.size());
            
            //分批插入数据库，每批500条
            int batchCount = 100;
            int index = 0;
            int size = kpireports.size();
            if(size > 0) {
                while(true) {
                    if(index + batchCount >= size) {
                        insertKPIReport(kpireports.subList(index, size));
                        insertKPIReportHis(kpireports.subList(index, size));
                        break;
                    }else {
                        insertKPIReport(kpireports.subList(index, index+batchCount));
                        insertKPIReportHis(kpireports.subList(index, index+batchCount));
                        index = index+batchCount;
                    }
                }
            }
        	}  
            } catch (Exception e) {
                 log.error("Failed to sync.", e);
              throw new RuntimeException(e);
            }
        return rows;
	}

	public void insertKPIReport(List<KPIReport> KPIReport) {
		  kpireportDao.insertKPIReport(KPIReport); 
	}
	public void insertKPIReportHis(List<KPIReport> KPIReport) {
		 kpireportDao.insertKPIReportHis(KPIReport);
		
	}

	@Override
	public void delKPIReport() {
		kpireportDao.delKPIReport();
		
	}

	@Override
	public void delKPIReportHis() {
		kpireportDao.delKPIReportHis();
	}

	@Override
	public List<KPIReport> getKPIReport() {
		return kpireportDao.getKPIReport();
	}

	@Override
	public List<MaterialType> getMatkl() {
		return kpireportDao.getMatkl();
	}

}
