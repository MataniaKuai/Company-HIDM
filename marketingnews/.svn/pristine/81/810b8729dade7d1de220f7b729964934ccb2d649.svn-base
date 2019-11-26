package com.hidm.newsmanage.dao;

import com.hidm.newsmanage.entity.NewsSystem;
import com.hidm.newsmanage.entity.NewsSystemFile;
import com.hidm.newsmanage.vo.NewsSystemSearchVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsSystemDao {
    public int insert(NewsSystemFile newsFile);
    
    public void updateById(NewsSystemFile newsFile);
    
    public int count(NewsSystemSearchVo news);
    
    public List<NewsSystemFile> selectList(NewsSystemSearchVo news);
    
    public void deleteByIds(Long[] ids);
}
