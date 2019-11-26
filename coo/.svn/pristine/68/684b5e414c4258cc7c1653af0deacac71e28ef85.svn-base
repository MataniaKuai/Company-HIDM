package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.BaseDataDao;
import com.hidm.coo.entity.BaseData;
import com.hidm.coo.service.BaseDataService;

@Service(value = "baseDataService")
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    private BaseDataDao baseDataDao;
    
    public List<BaseData> allCustomOffices() {
        return baseDataDao.allCustomOffices();
    }
}
