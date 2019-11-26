package com.hidm.newsmanage.vo;

import com.hidm.newsmanage.entity.NewsFile;

public class NewsFileVo extends NewsFile {
	
    private String fileName;
    
    private String filePath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
    
    
    
}
