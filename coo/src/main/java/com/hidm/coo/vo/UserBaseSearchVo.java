package com.hidm.coo.vo;

import com.hidm.coo.entity.UserBase;

public class UserBaseSearchVo {
    private UserBase userBase;

    private PaginationVo page;

    public UserBase getUserBase() {
        return userBase;
    }

    public void setUserBase(UserBase userBase) {
        this.userBase = userBase;
    }

    public PaginationVo getPage() {
        return page;
    }

    public void setPage(PaginationVo page) {
        this.page = page;
    }
   
	
}
