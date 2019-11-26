package com.hidm.newsmanage.dao;

import com.hidm.newsmanage.entity.NewsFile;
import com.hidm.newsmanage.vo.NewsFileSearchVo;
import com.hidm.newsmanage.vo.NewsFileVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsFileDao {
    public int count(NewsFileSearchVo newsFile);
    
    public List<NewsFileVo> selectList(NewsFileSearchVo newsFile);
    
}
