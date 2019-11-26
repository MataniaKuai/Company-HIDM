package com.hidm.importexport.dao;

import com.hidm.importexport.entity.FileInfo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileInfoDao {
    public int insert(FileInfo fileInfo);
    
    public void updateById(FileInfo fileInfo);
}
