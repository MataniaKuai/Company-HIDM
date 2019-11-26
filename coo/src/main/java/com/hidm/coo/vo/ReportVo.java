package com.hidm.coo.vo;

import java.math.BigDecimal;

public class ReportVo {
	private Long id;
	
	private Long userBaseId;
	
	private String eqTypeId;
    
    private String module;
    
    private String vendor;
    
    private String model;
    
    private String purchasePrice;
    
    private String tax;
    
    private String installationHookupCost;
    
    private BigDecimal floorCost;
    
    private BigDecimal floorCostAcount;
    
    private String housing;
    
    private String trainingCost;
    
    private String qualificationCost;
    
    private String operateLaborCost;
    
    private String maintainLaborCost;
    
    private String totalMaterialCost;
    
    private String partsCost;
    
    private String totalUtilityCost;
    
    private String mainServiceCost;
    
    private String additionalCost;
    
    private String waferCostRework;
    
    private String waferCostScrap;
    
    private String year;
    
    private String uph;
    
    private String uptimeRate;
    
    private String engineeringTimeRate;
    
    private String idleTimeRate;
    
    private String compositeYieldRate;
    
    private String reworkRate;
    
    private String scrapRate;
    
    private String cooValue;
    
    private Long uStatus;
	
    private Long mStatus;
    
    private Long oStatus;
    
    private Long pStatus;
    
    private Long iStatus;
    
    private Long userSubmit;
    
    private Long proSubmit;
    
    private Long opSubmit;
    
    private Long mfgSubmit;
    

    public Long getuStatus() {
		return uStatus;
	}

	public void setuStatus(Long uStatus) {
		this.uStatus = uStatus;
	}

	public Long getmStatus() {
		return mStatus;
	}

	public void setmStatus(Long mStatus) {
		this.mStatus = mStatus;
	}

	public Long getoStatus() {
		return oStatus;
	}

	public void setoStatus(Long oStatus) {
		this.oStatus = oStatus;
	}

	public Long getpStatus() {
		return pStatus;
	}

	public void setpStatus(Long pStatus) {
		this.pStatus = pStatus;
	}

	public Long getiStatus() {
		return iStatus;
	}

	public void setiStatus(Long iStatus) {
		this.iStatus = iStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEqTypeId() {
		return eqTypeId;
	}

	public void setEqTypeId(String eqTypeId) {
		this.eqTypeId = eqTypeId;
	}

	public BigDecimal getFloorCostAcount() {
        return floorCostAcount;
    }

    public void setFloorCostAcount(BigDecimal floorCostAcount) {
        this.floorCostAcount = floorCostAcount;
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

	public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getInstallationHookupCost() {
		return installationHookupCost;
	}

	public void setInstallationHookupCost(String installationHookupCost) {
		this.installationHookupCost = installationHookupCost;
	}

	public BigDecimal getFloorCost() {
		return floorCost;
	}

	public void setFloorCost(BigDecimal floorCost) {
		this.floorCost = floorCost;
	}

	public String getTrainingCost() {
		return trainingCost;
	}

	public void setTrainingCost(String trainingCost) {
		this.trainingCost = trainingCost;
	}

	public String getQualificationCost() {
		return qualificationCost;
	}

	public void setQualificationCost(String qualificationCost) {
		this.qualificationCost = qualificationCost;
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

	public String getTotalMaterialCost() {
		return totalMaterialCost;
	}

	public void setTotalMaterialCost(String totalMaterialCost) {
		this.totalMaterialCost = totalMaterialCost;
	}

	public String getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(String partsCost) {
		this.partsCost = partsCost;
	}

	public String getTotalUtilityCost() {
		return totalUtilityCost;
	}

	public void setTotalUtilityCost(String totalUtilityCost) {
		this.totalUtilityCost = totalUtilityCost;
	}

	public String getMainServiceCost() {
		return mainServiceCost;
	}

	public void setMainServiceCost(String mainServiceCost) {
		this.mainServiceCost = mainServiceCost;
	}

	public String getAdditionalCost() {
		return additionalCost;
	}

	public void setAdditionalCost(String additionalCost) {
		this.additionalCost = additionalCost;
	}

	public String getWaferCostRework() {
		return waferCostRework;
	}

	public void setWaferCostRework(String waferCostRework) {
		this.waferCostRework = waferCostRework;
	}

	public String getWaferCostScrap() {
		return waferCostScrap;
	}

	public void setWaferCostScrap(String waferCostScrap) {
		this.waferCostScrap = waferCostScrap;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getEngineeringTimeRate() {
		return engineeringTimeRate;
	}

	public void setEngineeringTimeRate(String engineeringTimeRate) {
		this.engineeringTimeRate = engineeringTimeRate;
	}

	public String getIdleTimeRate() {
		return idleTimeRate;
	}

	public void setIdleTimeRate(String idleTimeRate) {
		this.idleTimeRate = idleTimeRate;
	}

	public String getCompositeYieldRate() {
		return compositeYieldRate;
	}

	public void setCompositeYieldRate(String compositeYieldRate) {
		this.compositeYieldRate = compositeYieldRate;
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

	public String getCooValue() {
		return cooValue;
	}

	public void setCooValue(String cooValue) {
		this.cooValue = cooValue;
	}

	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
	}

    public Long getUserSubmit() {
        return userSubmit;
    }

    public void setUserSubmit(Long userSubmit) {
        this.userSubmit = userSubmit;
    }

    public Long getProSubmit() {
        return proSubmit;
    }

    public void setProSubmit(Long proSubmit) {
        this.proSubmit = proSubmit;
    }

    public Long getOpSubmit() {
        return opSubmit;
    }

    public void setOpSubmit(Long opSubmit) {
        this.opSubmit = opSubmit;
    }

    public Long getMfgSubmit() {
        return mfgSubmit;
    }

    public void setMfgSubmit(Long mfgSubmit) {
        this.mfgSubmit = mfgSubmit;
    }
	
}
