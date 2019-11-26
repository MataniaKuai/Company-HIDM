package com.hidm.newsmanage.vo;

import com.hidm.newsmanage.entity.NewsFile;

public class NewsFileSearchVo {
	private NewsFile newsFile;

	private PaginationVo page;

	public NewsFile getNewsFile() {
		return newsFile;
	}

	public void setNewsFile(NewsFile newsFile) {
		this.newsFile = newsFile;
	}

	public PaginationVo getPage() {
		return page;
	}

	public void setPage(PaginationVo page) {
		this.page = page;
	}
}
