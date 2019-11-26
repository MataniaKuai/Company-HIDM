package com.hidm.importexport.vo;

import com.hidm.importexport.entity.ImportBatch;

public class ImportBatchVo extends ImportBatch {
    private String irNo;
    
    private int isOverdue;
    
    private String grNo;
    
    private long itemId;
    
    private int status;
    
    private int isBatch;
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String moveType;
    
    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getItemId() {
        return itemId;
    }

    public String getGrNo() {
        return grNo;
    }

    public void setGrNo(String grNo) {
        this.grNo = grNo;
    }

    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getIrNo() {
        return irNo;
    }

    public void setIrNo(String irNo) {
        this.irNo = irNo;
    }

    public int getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(int isOverdue) {
        this.isOverdue = isOverdue;
    }

    public int getIsBatch() {
        return isBatch;
    }

    public void setIsBatch(int isBatch) {
        this.isBatch = isBatch;
    }

}
