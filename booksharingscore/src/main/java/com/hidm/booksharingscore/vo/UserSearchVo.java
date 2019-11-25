package com.hidm.booksharingscore.vo;

import com.hidm.booksharingscore.entity.User;

public class UserSearchVo {
    private User user;

    private PaginationVo page;
    
    private TimeRangeVo timeRange;
    
    private int[] statusArray;
    
    public int[] getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(int[] statusArray) {
        this.statusArray = statusArray;
    }

    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
