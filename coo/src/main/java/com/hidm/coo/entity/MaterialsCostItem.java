package com.hidm.coo.entity;

import java.util.Date;

public class MaterialsCostItem {
    private Long id;
    
    private Integer itemNo;
    
    private Long userBaseId;
    
    private String materialNo;
    
    private String usageByYear;
    
    private Date addTime;
    
    private String addUserId;
    
    private Date updateTime;
    
    private String updateUserId;
    
    private Integer delFlag;
    
    private String materialName;
    
    private String bomUnit;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserBaseId() {
        return userBaseId;
    }

    public void setUserBaseId(Long userBaseId) {
        this.userBaseId = userBaseId;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getUsageByYear() {
        return usageByYear;
    }

    public void setUsageByYear(String usageByYear) {
        this.usageByYear = usageByYear;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getBomUnit() {
		return bomUnit;
	}

	public void setBomUnit(String bomUnit) {
		this.bomUnit = bomUnit;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
    
}
