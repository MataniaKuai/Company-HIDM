package com.hidm.importexport.vo;

import com.hidm.importexport.entity.ImportItem;

public class ImportItemSearchVo {
    private String irNo;
    
    private String goodsCode;
    
    private String[] itemIds;
    
    private ImportItem importItem;

    private PaginationVo page;
    
    private TimeRangeVo timeRange;
    
    private Integer stat;
    
    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getIrNo() {
        return irNo;
    }

    public void setIrNo(String irNo) {
        this.irNo = irNo;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String[] getItemIds() {
        return itemIds;
    }

    public void setItemIds(String[] itemIds) {
        this.itemIds = itemIds;
    }

    public ImportItem getImportItem() {
        return importItem;
    }

    public void setImportItem(ImportItem importItem) {
        this.importItem = importItem;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }

    public TimeRangeVo getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(TimeRangeVo timeRange) {
        this.timeRange = timeRange;
    }
}
