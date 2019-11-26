package com.hidm.importexport.vo;

import com.hidm.importexport.entity.MaterialInventory;

public class MaterialInventoryVo extends MaterialInventory {

    private String taxPrepertyName;

    private String goodsCodeName;

    private String freeNoName;

    public String getTaxPrepertyName() {
        return taxPrepertyName;
    }

    public void setTaxPrepertyName(String taxPrepertyName) {
        this.taxPrepertyName = taxPrepertyName;
    }

    public String getGoodsCodeName() {
        return goodsCodeName;
    }

    public void setGoodsCodeName(String goodsCodeName) {
        this.goodsCodeName = goodsCodeName;
    }

    public String getFreeNoName() {
        return freeNoName;
    }

    public void setFreeNoName(String freeNoName) {
        this.freeNoName = freeNoName;
    }
    
}
