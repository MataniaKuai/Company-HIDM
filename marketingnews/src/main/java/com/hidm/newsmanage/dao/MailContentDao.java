package com.hidm.newsmanage.dao;

import com.hidm.newsmanage.entity.MailContent;
import com.hidm.newsmanage.entity.NewsSystemFile;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailContentDao {

	public int insert(MailContent mailContent);
	
    public int countWeekContent();
    
    public List<NewsSystemFile> selectWeekContent();
    
    public int countSummaryContent(MailContent mailContent);
    
    public List<MailContent> selectSummaryContent(MailContent mailContent);
    
}
