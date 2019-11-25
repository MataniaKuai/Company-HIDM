package com.hidm.importexport.entity;

public class AchievementsPrice implements  Comparable {
	
    private String matnr;
	
	private String cdate;
	
	private String stprs;
	
    private String werks;
	
	private String lgort;	
	
	private String maktx;
	
	private String zqcsl;
	
	private String zqmsl;
	
	private String zshsl;
	
	private String zfhsl;
	
	private String wgbez;
	
	private String matkl;
	
	private String meins;
	
	private double money;

	public String getMatkl() {
		return matkl;
	}

	public void setMatkl(String matkl) {
		this.matkl = matkl;
	}

	public String getWgbez() {
		return wgbez;
	}

	public void setWgbez(String wgbez) {
		this.wgbez = wgbez;
	}

	public String getMatnr() {
		return matnr;
	}

	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}

	public String getZqmsl() {
		return zqmsl;
	}

	public void setZqmsl(String zqmsl) {
		this.zqmsl = zqmsl;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getStprs() {
		return stprs;
	}

	public void setStprs(String stprs) {
		this.stprs = stprs;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public String getLgort() {
		return lgort;
	}

	public void setLgort(String lgort) {
		this.lgort = lgort;
	}

	public String getMaktx() {
		return maktx;
	}

	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}

	public String getZqcsl() {
		return zqcsl;
	}

	public void setZqcsl(String zqcsl) {
		this.zqcsl = zqcsl;
	}

	public String getZshsl() {
		return zshsl;
	}

	public void setZshsl(String zshsl) {
		this.zshsl = zshsl;
	}

	public String getZfhsl() {
		return zfhsl;
	}

	public void setZfhsl(String zfhsl) {
		this.zfhsl = zfhsl;
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public int compareTo(Object o) {
		AchievementsPrice s=(AchievementsPrice)o;
		 //升序
	    if(this.money==s.getMoney())
        return 0;
	    if(this.money<s.getMoney())
	    	return 1;
	    return -1;
    }
}
