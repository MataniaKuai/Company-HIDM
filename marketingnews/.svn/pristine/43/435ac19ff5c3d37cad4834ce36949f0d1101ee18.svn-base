package com.hidm.newsmanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hidm.newsmanage.entity.MailReceiver;
import com.hidm.newsmanage.vo.MailReceiverSearchVo;

@Mapper
public interface MailReceiverDao {
    public int insert(MailReceiver mailReceiver);
    
    public void updateById(MailReceiver mailReceiver);
    
    public int count(MailReceiverSearchVo mails);
    
    public List<MailReceiver> selectList(MailReceiverSearchVo mails);
    
    public void deleteByIds(Long[] ids);
    
    public int counter();
    
    public List<MailReceiver> select();
}
