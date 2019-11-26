package com.hidm.importexport.vo;

import com.hidm.importexport.entity.Asset;

public class AssetSearchVo {
    private Asset asset;

    private PaginationVo page;
    
    private TimeRangeVo timeRangeVo;

    public TimeRangeVo getTimeRangeVo() {
        return timeRangeVo;
    }

    public void setTimeRangeVo(TimeRangeVo timeRangeVo) {
        this.timeRangeVo = timeRangeVo;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }
}
