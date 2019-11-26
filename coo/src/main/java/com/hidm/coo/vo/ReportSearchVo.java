package com.hidm.coo.vo;

import java.util.List;

public class ReportSearchVo {
    private String eqTypeId;
    
    private List<String> vendorModels;
    
	public String getEqTypeId() {
		return eqTypeId;
	}

	public void setEqTypeId(String eqTypeId) {
		this.eqTypeId = eqTypeId;
	}

	public List<String> getVendorModels() {
		return vendorModels;
	}

	public void setVendorModels(List<String> vendorModels) {
		this.vendorModels = vendorModels;
	}
}
