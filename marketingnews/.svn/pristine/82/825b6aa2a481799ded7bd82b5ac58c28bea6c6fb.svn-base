package com.hidm.newsmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.dao.MailReceiverDao;
import com.hidm.newsmanage.entity.MailReceiver;
import com.hidm.newsmanage.entity.User;
import com.hidm.newsmanage.service.MailReceiverService;
import com.hidm.newsmanage.vo.MailReceiverSearchVo;

@Service(value = "mailReceiverService")
public class MailReceiverImpl implements MailReceiverService {
	@Autowired
    private MailReceiverDao mailReceiverDao;
	
    public int insert(MailReceiver mailReceiver) {
    	return mailReceiverDao.insert(mailReceiver);
    }
    
    public void updateById(MailReceiver mailReceiver) {
    	mailReceiverDao.updateById(mailReceiver);
    }
    
    public int count(MailReceiverSearchVo mails) {
    	return mailReceiverDao.count(mails);
    }
    
    public List<MailReceiver> selectList(MailReceiverSearchVo mails) {
    	return mailReceiverDao.selectList(mails);
    }
    
    public void deleteByIds(Long[] ids) {
    	if (null != ids && ids.length > 0) {
    		mailReceiverDao.deleteByIds(ids);
    	}
    }
    
    public int counter() {
	   return mailReceiverDao.counter();
    }
    
    public List<MailReceiver> select(){
    	return mailReceiverDao.select();
    }
    
}