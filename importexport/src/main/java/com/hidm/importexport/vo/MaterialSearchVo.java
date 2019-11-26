package com.hidm.importexport.vo;

import com.hidm.importexport.entity.Material;

public class MaterialSearchVo {
    private Material material;

    private PaginationVo page;
    
    private TimeRangeVo timeRange;

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
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
