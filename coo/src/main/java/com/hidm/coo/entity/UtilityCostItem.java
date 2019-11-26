package com.hidm.coo.entity;

import java.util.Date;

public class UtilityCostItem {
    private Long id;
    
    private Integer itemNo;
    
    private Long userBaseId;
    
    private String utility;
    
    private String usageByYear;
    
    private Date addTime;
    
    private String addUserId;
    
    private Date updateTime;
    
    private String updateUserId;
    
    private Integer delFlag;
    
    private String utilityName;
    
    private String utilityUnit;
    
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

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
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

	public String getUtilityName() {
		return utilityName;
	}

	public void setUtilityName(String utilityName) {
		this.utilityName = utilityName;
	}

	public String getUtilityUnit() {
		return utilityUnit;
	}

	public void setUtilityUnit(String utilityUnit) {
		this.utilityUnit = utilityUnit;
	}

	public Integer getItemNo() {
		return itemNo;
	}

	public void setItemNo(Integer itemNo) {
		this.itemNo = itemNo;
	}
    
}
