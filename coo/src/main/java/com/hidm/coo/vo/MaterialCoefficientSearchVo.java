package com.hidm.coo.vo;

import com.hidm.coo.entity.MaterialCoefficient;

public class MaterialCoefficientSearchVo {
    private MaterialCoefficient materialCoefficient;

    private PaginationVo page;

    public MaterialCoefficient getMaterialCoefficient() {
        return materialCoefficient;
    }

    public void setMaterialCoefficient(MaterialCoefficient materialCoefficient) {
        this.materialCoefficient = materialCoefficient;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }
}
