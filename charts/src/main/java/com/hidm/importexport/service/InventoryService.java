package com.hidm.importexport.service;

import java.util.List;

import com.hidm.importexport.entity.Inventory;
import com.hidm.importexport.entity.InventoryResult;
import com.hidm.importexport.entity.MaterialType;


public interface InventoryService {
    
    List<InventoryResult> countInventory(String date, String materialType);

    int sync();
    
    void insertInventory(List<Inventory> inventoryConsumptions);
    
    List<MaterialType> getMaterialType();
    
    void insertInventoryHis(List<Inventory> inventoryConsumptions);

    void delInventoryHis();

    void delInventory();

    List<InventoryResult> selectInventory(InventoryResult inventoryResults);
    
    List<InventoryResult> selectMonInventory(InventoryResult inventoryResults);

    List<InventoryResult> findByDateAndType(InventoryResult inventoryResults);

}
