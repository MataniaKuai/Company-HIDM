package com.hidm.importexport.service;

import java.util.List; 
import com.hidm.importexport.entity.KPIReport;
import com.hidm.importexport.entity.MaterialType;

public interface KPIReportService {
  
	int sync();
	
   public void insertKPIReport(List<KPIReport> KPIReport); 
   
   public void insertKPIReportHis(List<KPIReport> KPIReport); 
   
   void delKPIReport();
   
   void delKPIReportHis();
   
   List<KPIReport> getKPIReport();
   
   List<MaterialType> getMatkl();
	
}
