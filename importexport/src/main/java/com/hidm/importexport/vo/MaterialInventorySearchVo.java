package com.hidm.importexport.vo;

import com.hidm.importexport.entity.MaterialInventory;

public class MaterialInventorySearchVo{
    
    private MaterialInventory materialInventory;
    
    private String[] inventoryIds;
    
    private PaginationVo page;

    public MaterialInventory getMaterialInventory() {
        return materialInventory;
    }

    public void setMaterialInventory(MaterialInventory materialInventory) {
        this.materialInventory = materialInventory;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }

    public String[] getInventoryIds() {
        return inventoryIds;
    }

    public void setInventoryIds(String[] inventoryIds) {
        this.inventoryIds = inventoryIds;
    }
    
}
