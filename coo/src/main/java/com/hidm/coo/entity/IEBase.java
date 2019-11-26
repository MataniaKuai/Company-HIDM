package com.hidm.coo.entity;

import java.util.Date;
import java.math.BigDecimal;

public class IEBase {
    private Long id;
    
    private Long userBaseId;
    
    private BigDecimal operateLaborSalary;
    
    private BigDecimal maintainLaborSalary;
    
    private String operateLaborCost;
    
    private String maintainLaborCost;
    
    private BigDecimal floorCost;
    
    private BigDecimal floorCostAcount;
    
    private Date addTime;
    
    private String addUserId;
    
    private Date updateTime;
    
    private String updateUserId;
    
    private Integer delFlag;
    
    private String eqTypeId;
    
    private String module;
    
    private String vendor;
    
    private String model;
    
    private String length;
    
    private String housing;
    
    private String dspace;
    
    private String wspace;
    
    private String manMachine;
    
    private String shift;
    
    private String uph;
    
    private String uptimeRate;
    
    private String reworkRate;
    
    private String scrapRate;
    
    private String installationCost;
    
    private String hookupCost;
    
    private String installationHookupCost;
    
    private String qualificationCost;
    
    private String partsCost;
    
    private String waferCostRework;
    
    private String waferCostScrap;
    
    private String operational;
    
    private String operatert;
    
    private Integer status;
    
    private String cooValue;
    
    private String totalUtilityCost;
    
    private String totalMaterialCost;
    
    
    
    public String getWaferCostRework() {
		return waferCostRework;
	}

	public void setWaferCostRework(String waferCostRework) {
		this.waferCostRework = waferCostRework;
	}

	public String getCooValue() {
		return cooValue;
	}

	public void setCooValue(String cooValue) {
		this.cooValue = cooValue;
	}

	public String getWaferCostScrap() {
		return waferCostScrap;
	}

	public void setWaferCostScrap(String waferCostScrap) {
		this.waferCostScrap = waferCostScrap;
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

	public String getInstallationCost() {
		return installationCost;
	}

	public void setInstallationCost(String installationCost) {
		this.installationCost = installationCost;
	}

	public String getHookupCost() {
		return hookupCost;
	}

	public void setHookupCost(String hookupCost) {
		this.hookupCost = hookupCost;
	}

	public String getInstallationHookupCost() {
		return installationHookupCost;
	}

	public void setInstallationHookupCost(String installationHookupCost) {
		this.installationHookupCost = installationHookupCost;
	}

	public String getQualificationCost() {
		return qualificationCost;
	}

	public void setQualificationCost(String qualificationCost) {
		this.qualificationCost = qualificationCost;
	}

	public String getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(String partsCost) {
		this.partsCost = partsCost;
	}

	public String getHousing() {
		return housing;
	}

	public void setHousing(String housing) {
		this.housing = housing;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getTotalUtilityCost() {
        return totalUtilityCost;
    }

    public void setTotalUtilityCost(String totalUtilityCost) {
        this.totalUtilityCost = totalUtilityCost;
    }

    public String getTotalMaterialCost() {
        return totalMaterialCost;
    }

    public void setTotalMaterialCost(String totalMaterialCost) {
        this.totalMaterialCost = totalMaterialCost;
    }

    private String width;

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

	public String getOperateLaborCost() {
		return operateLaborCost;
	}

	public void setOperateLaborCost(String operateLaborCost) {
		this.operateLaborCost = operateLaborCost;
	}

	public String getMaintainLaborCost() {
		return maintainLaborCost;
	}

	public void setMaintainLaborCost(String maintainLaborCost) {
		this.maintainLaborCost = maintainLaborCost;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    public String getDspace() {
        return dspace;
    }

    public void setDspace(String dspace) {
        this.dspace = dspace;
    }

    public String getWspace() {
        return wspace;
    }

    public void setWspace(String wspace) {
        this.wspace = wspace;
    }
    
}
