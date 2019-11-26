package com.hidm.coo.vo;

import com.hidm.coo.entity.EQtype;

public class EQtypeSearchVo {
    private EQtype eqType;

    private PaginationVo page;

    public EQtype getEqType() {
        return eqType;
    }

    public void setEqType(EQtype eqType) {
        this.eqType = eqType;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }
}
