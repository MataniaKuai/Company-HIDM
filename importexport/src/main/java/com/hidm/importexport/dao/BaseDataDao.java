package com.hidm.importexport.dao;

import com.hidm.importexport.entity.BaseData;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BaseDataDao {
    public List<BaseData> allCustomOffices();
    
    public List<BaseData> allCurrencys();
    
    public List<BaseData> allTaxPrepertys();
    
    public List<BaseData> allBondCla1s();
    
    public List<BaseData> allBondCla2s();
    
    public List<BaseData> allFreeNos();
    
    public List<BaseData> allControlStatus();
    
    public List<BaseData> allRelieveModes();
    
    public List<BaseData> allOutReasons();
    
    public List<BaseData> allReexportReasons();
    
    public List<BaseData> allOrgs();
    
    public List<BaseData> allFreightTypes();
    
    public List<BaseData> allPackingTypes();
    
    public List<BaseData> allRecordNos();
    
    public List<BaseData> allAppTypes();
    
    public List<BaseData> allFreightTerms();
    
    public List<BaseData> allShipFromCountrys();
    
    public List<BaseData> allLoadingPorts();
    
    public List<BaseData> allImportCustoms();
    
    public List<BaseData> allImportPorts();
    
    public List<BaseData> allCarTypes();
    
    public List<BaseData> allTradingTypes();

    public List<BaseData> getPackingByName(@Param(value="name") String name);
}
