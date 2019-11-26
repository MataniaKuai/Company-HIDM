package com.hidm.coo.vo;

import com.hidm.coo.entity.Others;

public class OthersSearchVo {
    private Others others;

    private PaginationVo page;

    public Others getOthers() {
        return others;
    }

    public void setOthers(Others others) {
        this.others = others;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }
}
