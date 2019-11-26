package com.hidm.importexport.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ImportBatchHis {
    private Long id;
    
    private Long itemHisId;
    
    private String batchNo;
    
    private String poNo;

    private String poItem;

    private String sapBatchNo;

    private String unit;

    private BigDecimal qty;
    
    private Date produceTime;
    
    private Date addTime;
    
    private String addUser;
    
    private Integer delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemHisId() {
        return itemHisId;
    }

    public void setItemHisId(Long itemHisId) {
        this.itemHisId = itemHisId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getPoNo() {
        return poNo;
    }

    public void setPoNo(String poNo) {
        this.poNo = poNo;
    }

    public String getPoItem() {
        return poItem;
    }

    public void setPoItem(String poItem) {
        this.poItem = poItem;
    }

    public String getSapBatchNo() {
        return sapBatchNo;
    }

    public void setSapBatchNo(String sapBatchNo) {
        this.sapBatchNo = sapBatchNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

}
