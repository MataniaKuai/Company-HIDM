package com.hidm.importexport.vo;

import com.hidm.importexport.entity.ImportBatch;

public class ImportBatchSearchVo {
    private String irNo;
    
    private ImportBatch importBatch;

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

    public ImportBatch getImportBatch() {
        return importBatch;
    }

    public void setImportBatch(ImportBatch importBatch) {
        this.importBatch = importBatch;
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
