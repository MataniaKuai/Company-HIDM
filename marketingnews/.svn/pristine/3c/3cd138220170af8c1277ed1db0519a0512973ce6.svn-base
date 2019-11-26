package com.hidm.newsmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.newsmanage.dao.NewsFileDao;
import com.hidm.newsmanage.entity.NewsFile;
import com.hidm.newsmanage.service.NewsFileService;
import com.hidm.newsmanage.vo.NewsFileSearchVo;
import com.hidm.newsmanage.vo.NewsFileVo;

@Service(value = "newsFileService")
public class NewsFileServiceImpl implements NewsFileService {
	@Autowired
    private NewsFileDao newsFileDao;

    public int count(NewsFileSearchVo newsFile) {
    	return newsFileDao.count(newsFile);
    }
    
    public List<NewsFileVo> selectList(NewsFileSearchVo newsFile) {
    	return newsFileDao.selectList(newsFile);
    }
    
}
