package com.hidm.importexport.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ControlDetail {
    private Long id;
    
    private String materialNo;
    
    private String assetNo;
    
    private String irNo;
    
    private String goodsCode;
    
    private String goodsDesc;
    
    private String chineseName;
    
    private Date releaseTime;
    
    private Date expireTime;
    
    private String controlStatus;
    
    private String relieveMode;
    
    private String taxPreperty;
    
    ///
    private Date outTime;
    
    private String outReason;
    
    private String reexportReason;
    
    private String reexportNo;
    
    private String outReleaseNo;
    
    private Integer isReturn;
    
    private Date returnTime;
    
    private Date relieveTime;
    ///
    
    private Date updateTime;
    
    private Date addTime;
    
    private String updateUser;
    
    private String addUser;
    
    private Integer delFlag;

    private Long importItemId;
    
    private String employeeNo;
    
    private String poNo;
    
    private String poItem;
    
    private String grNo;
    
    private BigDecimal outQty;
    
    public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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

	public String getGrNo() {
		return grNo;
	}

	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
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

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getRelieveMode() {
        return relieveMode;
    }

    public void setRelieveMode(String relieveMode) {
        this.relieveMode = relieveMode;
    }

    public String getIrNo() {
        return irNo;
    }

    public void setIrNo(String irNo) {
        this.irNo = irNo;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
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

    public String getTaxPreperty() {
        return taxPreperty;
    }

    public void setTaxPreperty(String taxPreperty) {
        this.taxPreperty = taxPreperty;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getReexportReason() {
        return reexportReason;
    }

    public void setReexportReason(String reexportReason) {
        this.reexportReason = reexportReason;
    }

    public String getReexportNo() {
        return reexportNo;
    }

    public void setReexportNo(String reexportNo) {
        this.reexportNo = reexportNo;
    }

    public String getOutReleaseNo() {
        return outReleaseNo;
    }

    public void setOutReleaseNo(String outReleaseNo) {
        this.outReleaseNo = outReleaseNo;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Date getRelieveTime() {
        return relieveTime;
    }

    public void setRelieveTime(Date relieveTime) {
        this.relieveTime = relieveTime;
    }

    public Long getImportItemId() {
        return importItemId;
    }

    public void setImportItemId(Long importItemId) {
        this.importItemId = importItemId;
    }

    public BigDecimal getOutQty() {
        return outQty;
    }

    public void setOutQty(BigDecimal outQty) {
        this.outQty = outQty;
    }
    
}
