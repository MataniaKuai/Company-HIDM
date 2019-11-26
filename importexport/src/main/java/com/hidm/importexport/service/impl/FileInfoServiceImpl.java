package com.hidm.importexport.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.importexport.dao.FileInfoDao;
import com.hidm.importexport.entity.FileInfo;
import com.hidm.importexport.service.FileInfoService;

@Service(value = "fileInfoService")
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    private FileInfoDao fileInfoDao;
    
    public int insert(FileInfo fileInfo) {
        return fileInfoDao.insert(fileInfo);
    }
    
    public void updateById(FileInfo fileInfo) {
        fileInfo.setUpdateTime(new Date());
        fileInfoDao.updateById(fileInfo);
    }
}
