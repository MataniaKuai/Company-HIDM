package com.hidm.coo.vo;

import com.hidm.coo.entity.IEBase;

public class IEBaseSearchVo {
    private IEBase ieBase;

    private PaginationVo page;

	public IEBase getIeBase() {
		return ieBase;
	}

	public void setIeBase(IEBase ieBase) {
		this.ieBase = ieBase;
	}

	public PaginationVo getPage() {
		return page;
	}

	public void setPage(PaginationVo page) {
		this.page = page;
	}

}
