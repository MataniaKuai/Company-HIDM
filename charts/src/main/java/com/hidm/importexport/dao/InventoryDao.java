package com.hidm.importexport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hidm.importexport.entity.Inventory;
import com.hidm.importexport.entity.InventoryResult;
import com.hidm.importexport.entity.MaterialType;

@Mapper
public interface InventoryDao {
	
	public List<InventoryResult> countInventory(@Param("date")String date, @Param("materialType")String materialType);

	public void insertInventory(List<Inventory> inventoryConsumptions);
	
    public void insertInventoryHis(List<Inventory> inventoryConsumptions);

    public void delInventoryHis(int days);

    public void delInventory();
    
	public List<MaterialType> getMaterialType();

    public List<InventoryResult> selectInventory(InventoryResult inventoryResults);
    
    public List<InventoryResult> selectMonInventory(InventoryResult inventoryResults);
    
    public List<InventoryResult> findByDateAndType(InventoryResult inventoryResults);
}
