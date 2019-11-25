package com.hidm.booksharingscore.vo;

public class SigninInfoSearchVo {
	
	private String nowDate;
	
    private PaginationVo page;
    
    private TimeRangeVo timeRange;
    
    private int[] statusArray;

	public String getNowDate() {
		return nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
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

	public int[] getStatusArray() {
		return statusArray;
	}

	public void setStatusArray(int[] statusArray) {
		this.statusArray = statusArray;
	}
}
