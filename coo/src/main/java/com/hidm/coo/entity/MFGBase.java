package com.hidm.coo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MFGBase {
    private Long id;
    
    private Integer isSubmit;  
    
    private Long userBaseId;
    
    private String operational;
    
    private String operatert;
    
    private Date addTime;
    
    private String addUserId;
    
    private Date updateTime;
    
    private String updateUserId;
    
    private Integer delFlag;
    
    private String eqTypeId;
    
    private String module;
    
    private String vendor;
    
    private String model;
    
    private String uph;
    
    private String uptimeRate;
    
    private String reworkRate;
    
    private String scrapRate;
    
    private String manMachine;
    
    private String shift;
    
    private Integer status;
    
    private Integer maintainStatus;
    
    private BigDecimal operateLaborSalary;
    
    private BigDecimal maintainLaborSalary;
    
    private BigDecimal floorCost;
    
    private BigDecimal floorCostAcount;
    
    private String housing;
    
    private String operateLaborCost;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public Integer getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(Integer isSubmit) {
		this.isSubmit = isSubmit;
	}

	public Long getUserBaseId() {
        return userBaseId;
    }

    public void setUserBaseId(Long userBaseId) {
        this.userBaseId = userBaseId;
    }

    public String getOperational() {
        return operational;
    }

    public void setOperational(String operational) {
        this.operational = operational;
    }

    public String getOperatert() {
        return operatert;
    }

    public void setOperatert(String operatert) {
        this.operatert = operatert;
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
    
	public String getEqTypeId() {
		return eqTypeId;
	}

	public void setEqTypeId(String eqTypeId) {
		this.eqTypeId = eqTypeId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getUph() {
		return uph;
	}
	
	public void setUph(String uph) {
		this.uph = uph;
	}
	
	public String getUptimeRate() {
		return uptimeRate;
	}

	public void setUptimeRate(String uptimeRate) {
		this.uptimeRate = uptimeRate;
	}
	
	public String getReworkRate() {
		return reworkRate;
	}

	public void setReworkRate(String reworkRate) {
		this.reworkRate = reworkRate;
	}
	
	public String getScrapRate() {
		return scrapRate;
	}

	public void setScrapRate(String scrapRate) {
		this.scrapRate = scrapRate;
	}
	
    public String getManMachine() {
        return manMachine;
    }

    public void setManMachine(String manMachine) {
        this.manMachine = manMachine;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMaintainStatus() {
		return maintainStatus;
	}

	public void setMaintainStatus(Integer maintainStatus) {
		this.maintainStatus = maintainStatus;
	}

	public BigDecimal getOperateLaborSalary() {
		return operateLaborSalary;
	}

	public void setOperateLaborSalary(BigDecimal operateLaborSalary) {
		this.operateLaborSalary = operateLaborSalary;
	}

	public BigDecimal getMaintainLaborSalary() {
		return maintainLaborSalary;
	}

	public void setMaintainLaborSalary(BigDecimal maintainLaborSalary) {
		this.maintainLaborSalary = maintainLaborSalary;
	}

	public BigDecimal getFloorCost() {
		return floorCost;
	}

	public void setFloorCost(BigDecimal floorCost) {
		this.floorCost = floorCost;
	}

	public BigDecimal getFloorCostAcount() {
		return floorCostAcount;
	}

	public void setFloorCostAcount(BigDecimal floorCostAcount) {
		this.floorCostAcount = floorCostAcount;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getOperateLaborCost() {
		return operateLaborCost;
	}

	public void setOperateLaborCost(String operateLaborCost) {
		this.operateLaborCost = operateLaborCost;
	}
	
}
