package com.hidm.importexport.vo;

public class KPIReportVo {
     private String type;
     
     private String group;
     
     private String matklgroup;
     
     private double expenseValue;
     
     private double inventoryValue;
     
     private double idleValue;
     
     private double expenseRate;
     
     private double inventoryRate;
     
     private double idleRate;
     
     private double startValue;
     
     private int Lifetime;
     
     private int daytime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public double getInventoryValue() {
		return inventoryValue;
	}

	public void setInventoryValue(double inventoryValue) {
		this.inventoryValue = inventoryValue;
	}

	public double getIdleValue() {
		return idleValue;
	}

	public void setIdleValue(double idleValue) {
		this.idleValue = idleValue;
	}

	public void setExpenseValue(double expenseValue) {
		this.expenseValue = expenseValue;
	}

	public double getStartValue() {
		return startValue;
	}

	public void setStartValue(double startValue) {
		this.startValue = startValue;
	}

	public double getExpenseValue() {
		return expenseValue;
	}

	public int getDaytime() {
		return daytime;
	}

	public void setDaytime(int daytime) {
		this.daytime = daytime;
	}

	public String getMatklgroup() {
		return matklgroup;
	}

	public void setMatklgroup(String matklgroup) {
		this.matklgroup = matklgroup;
	}

	public int getLifetime() {
		return Lifetime;
	}

	public void setLifetime(int lifetime) {
		Lifetime = lifetime;
	}

	public double getExpenseRate() {
		return expenseRate;
	}

	public void setExpenseRate(double expenseRate) {
		this.expenseRate = expenseRate;
	}

	public double getInventoryRate() {
		return inventoryRate;
	}

	public void setInventoryRate(double inventoryRate) {
		this.inventoryRate = inventoryRate;
	}

	public double getIdleRate() {
		return idleRate;
	}

	public void setIdleRate(double idleRate) {
		this.idleRate = idleRate;
	}

	
}