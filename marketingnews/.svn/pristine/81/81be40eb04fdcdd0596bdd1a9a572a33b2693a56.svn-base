package com.hidm.newsmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.dao.MailContentDao;
import com.hidm.newsmanage.dao.NewsSystemDao;
import com.hidm.newsmanage.entity.MailContent;
import com.hidm.newsmanage.entity.NewsSystem;
import com.hidm.newsmanage.entity.NewsSystemFile;
import com.hidm.newsmanage.service.MailContentService;
import com.hidm.newsmanage.service.NewsSystemService;
import com.hidm.newsmanage.vo.NewsSystemSearchVo;

@Service(value = "mailContentService")
public class MailContentServiceImpl implements MailContentService {
	@Autowired
    private MailContentDao mailContentDao;
	
	public int insert(MailContent mailContent) {
		return mailContentDao.insert(mailContent);
	}
	
	public int countWeekContent() {
		return mailContentDao.countWeekContent();
	}
    
	public List<NewsSystemFile> selectWeekContent(){
		return mailContentDao.selectWeekContent();
	}

	public int countSummaryContent(MailContent mailContent) {
		return mailContentDao.countSummaryContent(mailContent);
	}
    
	public List<MailContent> selectSummaryContent(MailContent mailContent){
		return mailContentDao.selectSummaryContent(mailContent);
	}
}
