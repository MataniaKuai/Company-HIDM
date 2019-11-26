package com.hidm.importexport.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ImportItem {
    private Long id;
    
    private String poNo;
    
    private String poItem;
    
    private String vendor;
    
    private String materialNo;
    
    private Long importId;
    
    private String goodsDesc;
    
    private String chineseName;
    
    private String unit;
    
    private BigDecimal qty;
    
    private Double unitPrice;
    
    private Double totalAmount;
    
    private String currency;
    
    private String assetNo;
    
    private String tradeTerm;
    
    private String hsCode;
    
    private String grNo;
    
    private String relatedGrNo;
    
    private String dept;
    
    private String employeeNo;
    
    private String stock;
    
    private Date updateTime;
    
    private Date addTime;
    
    private String updateUser;
    
    private String addUser;
    
    private Integer delFlag;
    
    private String moveType;
    
    private Integer status;
    
    private String grYear;
    
    private int grItem;
    
    private String relatedGrYear;
    
    private int relatedGrItem;
    
    private Integer isBatch;
    
    private int isEdit;
    
    private float tariffRate;   //关税税率
    
    private String tradingUnit;   //交易单位
    
    private BigDecimal transactionVolume;   //交易量
    
    private String legalUnit;   //法律单位
    
    private BigDecimal legalQuantity;   //法定数量
    
    private String childAssetNo;
    
    public float getTariffRate() {
		return tariffRate;
	}

	public void setTariffRate(float tariffRate) {
		this.tariffRate = tariffRate;
	}

	public String getTradingUnit() {
		return tradingUnit;
	}

	public void setTradingUnit(String tradingUnit) {
		this.tradingUnit = tradingUnit;
	}

	public String getLegalUnit() {
		return legalUnit;
	}

	public void setLegalUnit(String legalUnit) {
		this.legalUnit = legalUnit;
	}

	public BigDecimal getTransactionVolume() {
        return transactionVolume;
    }

    public void setTransactionVolume(BigDecimal transactionVolume) {
        this.transactionVolume = transactionVolume;
    }

    public BigDecimal getLegalQuantity() {
        return legalQuantity;
    }

    public void setLegalQuantity(BigDecimal legalQuantity) {
        this.legalQuantity = legalQuantity;
    }

    public int getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(int isEdit) {
		this.isEdit = isEdit;
	}

	public String getGrYear() {
        return grYear;
    }

    public void setGrYear(String grYear) {
        this.grYear = grYear;
    }

    public int getGrItem() {
        return grItem;
    }

    public void setGrItem(int grItem) {
        this.grItem = grItem;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getTradeTerm() {
        return tradeTerm;
    }

    public void setTradeTerm(String tradeTerm) {
        this.tradeTerm = tradeTerm;
    }

    public String getHsCode() {
        return hsCode;
    }

    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public String getGrNo() {
        return grNo;
    }

    public void setGrNo(String grNo) {
        this.grNo = grNo;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRelatedGrNo() {
        return relatedGrNo;
    }

    public void setRelatedGrNo(String relatedGrNo) {
        this.relatedGrNo = relatedGrNo;
    }

    public String getRelatedGrYear() {
        return relatedGrYear;
    }

    public void setRelatedGrYear(String relatedGrYear) {
        this.relatedGrYear = relatedGrYear;
    }

    public int getRelatedGrItem() {
        return relatedGrItem;
    }

    public void setRelatedGrItem(int relatedGrItem) {
        this.relatedGrItem = relatedGrItem;
    }

    public Integer getIsBatch() {
        return isBatch;
    }

    public void setIsBatch(Integer isBatch) {
        this.isBatch = isBatch;
    }

    public String getChildAssetNo() {
        return childAssetNo;
    }

    public void setChildAssetNo(String childAssetNo) {
        this.childAssetNo = childAssetNo;
    }
    
}
