package com.hidm.newsmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.dao.NewsSystemDao;
import com.hidm.newsmanage.entity.NewsSystem;
import com.hidm.newsmanage.entity.NewsSystemFile;
import com.hidm.newsmanage.service.NewsSystemService;
import com.hidm.newsmanage.vo.NewsSystemSearchVo;

@Service(value = "newsSystemService")
public class NewsSystemServiceImpl implements NewsSystemService {
	@Autowired
    private NewsSystemDao newsSystemDao;
	
    public int insert(NewsSystemFile newsSystemFile) {
    	return newsSystemDao.insert(newsSystemFile);
    }
    
    public void updateById(NewsSystemFile newsSystemFile) {
    	newsSystemDao.updateById(newsSystemFile);
    }
    
    public int count(NewsSystemSearchVo newsSystem) {
    	return newsSystemDao.count(newsSystem);
    }
    
    public List<NewsSystemFile> selectList(NewsSystemSearchVo newsSystem) {
    	return newsSystemDao.selectList(newsSystem);
    }
    
    public void deleteByIds(Long[] ids) {
    	if (null != ids && ids.length > 0) {
    		newsSystemDao.deleteByIds(ids);
    	}
    }
}
