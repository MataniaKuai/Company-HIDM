package com.hidm.newsmanage.service;
import java.util.List;

import com.hidm.newsmanage.entity.MailContent;
import com.hidm.newsmanage.entity.NewsSystemFile;

public interface MailContentService {
	
    public int insert(MailContent mailContent);
	
	public int countWeekContent();
    
	public List<NewsSystemFile> selectWeekContent();
	
	public int countSummaryContent(MailContent mailContent);
    
	public List<MailContent> selectSummaryContent(MailContent mailContent);
}
