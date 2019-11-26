package com.hidm.coo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hidm.coo.dao.EQMouduleDao;
import com.hidm.coo.service.EQMouduleService;
import com.hidm.coo.vo.EQMouduleVo;

@Service(value = "eqMouduleService")
public class EQMouduleServiceImpl implements EQMouduleService {
    @Autowired
    private EQMouduleDao eqMouduleDao;

    @Override
    public List<EQMouduleVo> selectAll() {
        return eqMouduleDao.selectAll();
    }
}
