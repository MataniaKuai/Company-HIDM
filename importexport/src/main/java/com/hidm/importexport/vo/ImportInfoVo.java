package com.hidm.importexport.vo;

import com.hidm.importexport.constant.ImportInfoConstant;
import com.hidm.importexport.entity.ImportInfo;

public class ImportInfoVo extends ImportInfo {
    private String freightTypeName;
    
    private String goodsCodeName;
    
    private String shipFromCountryName;
    
    private String shipFromPortName;
    
    private String loadingPortName;
    
    private String importCustomName;
    
    private String importPortName;
    
    private String dischargePortName;

    private String originalCountryName;
    
    private String tradingTypeName;
    
    private String taxPrepertyName;
    
    
    public String getShipFromCountryName() {
        return shipFromCountryName;
    }

    public void setShipFromCountryName(String shipFromCountryName) {
        this.shipFromCountryName = shipFromCountryName;
    }

    public String getShipFromPortName() {
        return shipFromPortName;
    }

    public void setShipFromPortName(String shipFromPortName) {
        this.shipFromPortName = shipFromPortName;
    }

    public String getLoadingPortName() {
        return loadingPortName;
    }

    public void setLoadingPortName(String loadingPortName) {
        this.loadingPortName = loadingPortName;
    }

    public String getImportCustomName() {
        return importCustomName;
    }

    public void setImportCustomName(String importCustomName) {
        this.importCustomName = importCustomName;
    }

    public String getImportPortName() {
        return importPortName;
    }

    public void setImportPortName(String importPortName) {
        this.importPortName = importPortName;
    }

    public String getGoodsCodeName() {
        return goodsCodeName;
    }

    public void setGoodsCodeName(String goodsCodeName) {
        this.goodsCodeName = goodsCodeName;
    }

    public String getFreightTypeName() {
        return freightTypeName;
    }

    public void setFreightTypeName(String freightTypeName) {
        this.freightTypeName = freightTypeName;
    }

    public String getDischargePortName() {
        return dischargePortName;
    }

    public void setDischargePortName(String dischargePortName) {
        this.dischargePortName = dischargePortName;
    }

    public String getStatusDesc() {
        int status = null == getStatus() ? 0 : getStatus();
        return ImportInfoConstant.getStatusDesc(status);
    }

    public String getOriginalCountryName() {
        return originalCountryName;
    }

    public void setOriginalCountryName(String originalCountryName) {
        this.originalCountryName = originalCountryName;
    }

    public String getTradingTypeName() {
        return tradingTypeName;
    }

    public void setTradingTypeName(String tradingTypeName) {
        this.tradingTypeName = tradingTypeName;
    }

    public String getTaxPrepertyName() {
        return taxPrepertyName;
    }

    public void setTaxPrepertyName(String taxPrepertyName) {
        this.taxPrepertyName = taxPrepertyName;
    }
    
}
