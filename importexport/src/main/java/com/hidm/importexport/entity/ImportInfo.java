package com.hidm.importexport.entity;

import java.util.Date;

public class ImportInfo {
    private Long id;
    
    private String org;
    
    private String freightType;
    
    private String goodsCode;
    
    private String irNo;
    
    private String declarationNo;
    
    private Date declarationTime;
    
    private Date releaseTime;
    
    private Date arriveTime;
    
    private Date receiveTime;
    
    private Date sailingTime;
    
    private Double gw;
    
    private Double nw;
    
    private Double chw;
    
    private Integer totalPackage;
    
    private String packingType;
    
    private String recordNo;
    
    private Integer unusual;
    
    private String appType;
    
    private String broker;
    
    private String forwarder;
    
    private String freightTerm;
    
    private String bl;
    
    private String mawb;
    
    private String hawb;
    
    private String flightVesselVoy;
    
    private String shipFromCountry;
    
    private String shipFromPort;
    
    private String loadingPort;
    
    private String dischargePort;
    
    private Date inhouseDate;
    
    private Date outhouseDate;
    
    private String invoiceNo;
    
    private String importCustom;
    
    private String importPort;
    
    private String lcNo;
    
    private String containerNo;
    
    private String carType;
    
    private String carNo;
    
    private String rmaNo;
    
    private Integer rmaQty;
    
    private String originalDeclarationNo;
    
    private String originalIrNo;
    
    private String importPerson;
    
    private String finalReviser;
    
    private Date lastModifiedTime;
    
    private String remarks;
    
    private String originalCountry;
    
    private String declaringCustom;
    
    private String text1;
    
    private String text2;
    
    private String text3;
    
    /**
     * 1 - Released
     * 2 - Received
     */
    private Integer status;
    
    private Date updateTime;
    
    private Date addTime;
    
    private String updateUser;
    
    private String addUser;
    
    private Integer delFlag;
    
    private String tradingType;
    
    private String taxPreperty;
    
    private String tariffTax;
    
    private String tariff;
    
    private String valueAddedTax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getFreightType() {
        return freightType;
    }

    public void setFreightType(String freightType) {
        this.freightType = freightType;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getIrNo() {
        return irNo;
    }

    public void setIrNo(String irNo) {
        this.irNo = irNo;
    }

    public String getDeclarationNo() {
        return declarationNo;
    }

    public void setDeclarationNo(String declarationNo) {
        this.declarationNo = declarationNo;
    }

    public Date getDeclarationTime() {
        return declarationTime;
    }

    public void setDeclarationTime(Date declarationTime) {
        this.declarationTime = declarationTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getSailingTime() {
        return sailingTime;
    }

    public void setSailingTime(Date sailingTime) {
        this.sailingTime = sailingTime;
    }

    public Double getGw() {
        return gw;
    }

    public void setGw(Double gw) {
        this.gw = gw;
    }

    public Double getNw() {
        return nw;
    }

    public void setNw(Double nw) {
        this.nw = nw;
    }

    public Double getChw() {
        return chw;
    }

    public void setChw(Double chw) {
        this.chw = chw;
    }

    public Integer getTotalPackage() {
        return totalPackage;
    }

    public void setTotalPackage(Integer totalPackage) {
        this.totalPackage = totalPackage;
    }

    public String getPackingType() {
        return packingType;
    }

    public void setPackingType(String packingType) {
        this.packingType = packingType;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public Integer getUnusual() {
        return unusual;
    }

    public void setUnusual(Integer unusual) {
        this.unusual = unusual;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getForwarder() {
        return forwarder;
    }

    public void setForwarder(String forwarder) {
        this.forwarder = forwarder;
    }

    public String getFreightTerm() {
        return freightTerm;
    }

    public void setFreightTerm(String freightTerm) {
        this.freightTerm = freightTerm;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getMawb() {
        return mawb;
    }

    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    public String getHawb() {
        return hawb;
    }

    public void setHawb(String hawb) {
        this.hawb = hawb;
    }

    public String getFlightVesselVoy() {
        return flightVesselVoy;
    }

    public void setFlightVesselVoy(String flightVesselVoy) {
        this.flightVesselVoy = flightVesselVoy;
    }

    public String getShipFromCountry() {
        return shipFromCountry;
    }

    public void setShipFromCountry(String shipFromCountry) {
        this.shipFromCountry = shipFromCountry;
    }

    public String getShipFromPort() {
        return shipFromPort;
    }

    public void setShipFromPort(String shipFromPort) {
        this.shipFromPort = shipFromPort;
    }

    public String getLoadingPort() {
        return loadingPort;
    }

    public void setLoadingPort(String loadingPort) {
        this.loadingPort = loadingPort;
    }

    public String getDischargePort() {
        return dischargePort;
    }

    public void setDischargePort(String dischargePort) {
        this.dischargePort = dischargePort;
    }

    public Date getInhouseDate() {
        return inhouseDate;
    }

    public void setInhouseDate(Date inhouseDate) {
        this.inhouseDate = inhouseDate;
    }

    public Date getOuthouseDate() {
        return outhouseDate;
    }

    public void setOuthouseDate(Date outhouseDate) {
        this.outhouseDate = outhouseDate;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getImportCustom() {
        return importCustom;
    }

    public void setImportCustom(String importCustom) {
        this.importCustom = importCustom;
    }

    public String getImportPort() {
        return importPort;
    }

    public void setImportPort(String importPort) {
        this.importPort = importPort;
    }

    public String getLcNo() {
        return lcNo;
    }

    public void setLcNo(String lcNo) {
        this.lcNo = lcNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getRmaNo() {
        return rmaNo;
    }

    public void setRmaNo(String rmaNo) {
        this.rmaNo = rmaNo;
    }

    public Integer getRmaQty() {
        return rmaQty;
    }

    public void setRmaQty(Integer rmaQty) {
        this.rmaQty = rmaQty;
    }

    public String getOriginalDeclarationNo() {
        return originalDeclarationNo;
    }

    public void setOriginalDeclarationNo(String originalDeclarationNo) {
        this.originalDeclarationNo = originalDeclarationNo;
    }

    public String getOriginalIrNo() {
        return originalIrNo;
    }

    public void setOriginalIrNo(String originalIrNo) {
        this.originalIrNo = originalIrNo;
    }

    public String getImportPerson() {
        return importPerson;
    }

    public void setImportPerson(String importPerson) {
        this.importPerson = importPerson;
    }

    public String getFinalReviser() {
        return finalReviser;
    }

    public void setFinalReviser(String finalReviser) {
        this.finalReviser = finalReviser;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(String originalCountry) {
        this.originalCountry = originalCountry;
    }

    public String getDeclaringCustom() {
        return declaringCustom;
    }

    public void setDeclaringCustom(String declaringCustom) {
        this.declaringCustom = declaringCustom;
    }

    public String getTradingType() {
        return tradingType;
    }

    public void setTradingType(String tradingType) {
        this.tradingType = tradingType;
    }

    public String getTaxPreperty() {
        return taxPreperty;
    }

    public void setTaxPreperty(String taxPreperty) {
        this.taxPreperty = taxPreperty;
    }

    public String getTariffTax() {
        return tariffTax;
    }

    public void setTariffTax(String tariffTax) {
        this.tariffTax = tariffTax;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getValueAddedTax() {
        return valueAddedTax;
    }

    public void setValueAddedTax(String valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }
    
}
