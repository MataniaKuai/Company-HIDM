package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.importexport.entity.KPIReport;
import com.hidm.importexport.entity.MaterialType;

@Mapper
public interface KPIReportDao {
	   int sync();
	  
	   public void insertKPIReportHis(List<KPIReport> KPIReport);

	   public void insertKPIReport(List<KPIReport> kPIReport); 
	   
	   void delKPIReport();
	   
	   void delKPIReportHis();
		
	   public List<KPIReport> getKPIReport();
	   
	   List<MaterialType> getMatkl();
	

}
