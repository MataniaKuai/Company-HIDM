package com.hidm.importexport.entity;

import java.util.List;

public class InventoryResult implements  Comparable{
	// 物料组
//    private String materialType;
    // 记录价格总数，201领料记录正数，202退料记录负数
    private String count;
    
    // 物料组描述
    private String wgbez;
    // 时间
    private String date;
    // 领退料标识
    private String bwart;
	// 数量
    private String erfmg;
    // 价格控制"S/V"
    private String vprsv;
    // 标准价格
    private String stprs;
    // 移动平均价
    private String verpr;
    
    private List<String> materialTypes;
    
    private String inMonth;    
    
    //品名描述
    private String maktx;
    
    //料号
    private String matnr;
    
    //物料凭证
    private String mblnr;
    
    //金额
    private double money;
    
    //物料組
    private String matkl;
    //
    private String erfme;
    
    public String getMatkl() {
		return matkl;
	}
	public void setMatkl(String matkl) {
		this.matkl = matkl;
	}
//	public String getMaterialType() {
//        return materialType;
//    }
//    public void setMaterialType(String materialType) {
//        this.materialType = materialType;
//    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getWgbez() {
        return wgbez;
    }
    public void setWgbez(String wgbez) {
        this.wgbez = wgbez;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getBwart() {
        return bwart;
    }
    public void setBwart(String bwart) {
        this.bwart = bwart;
    }
    public String getErfmg() {
        return erfmg;
    }
    public void setErfmg(String erfmg) {
        this.erfmg = erfmg;
    }
    public String getVprsv() {
        return vprsv;
    }
    public void setVprsv(String vprsv) {
        this.vprsv = vprsv;
    }
    public String getStprs() {
        return stprs;
    }
    public void setStprs(String stprs) {
        this.stprs = stprs;
    }
    public String getVerpr() {
        return verpr;
    }
    public void setVerpr(String verpr) {
        this.verpr = verpr;
    }
	public List<String> getMaterialTypes() {
		return materialTypes;
	}
	public void setMaterialTypes(List<String> materialTypes) {
		this.materialTypes = materialTypes;
	}
	
	
	public String getInMonth() {
		return inMonth;
	}
	public void setInMonth(String inMonth) {
		this.inMonth = inMonth;
	}
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getMblnr() {
		return mblnr;
	}
	public void setMblnr(String mblnr) {
		this.mblnr = mblnr;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getErfme() {
		return erfme;
	}
	public void setErfme(String erfme) {
		this.erfme = erfme;
	}
	@Override
	public int compareTo(Object o) {
		InventoryResult s=(InventoryResult)o;
		 //升序
	    if(this.money==s.getMoney())
        return 0;
	    if(this.money<s.getMoney())
	    	return 1;
	    return -1;
    }
    
}
