package com.hidm.coo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.hidm.coo.dao.BusinessHisDao;
import com.hidm.coo.entity.BusinessHis;
import com.hidm.coo.entity.User;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.util.JsonUtil;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.BusinessHisSearchVo;

@Service(value="businessHisService")
public class BusinessHisServiceImpl implements BusinessHisService {
    private static Logger log = Logger.getLogger(BusinessHisServiceImpl.class);
    
    @Autowired
    private BusinessHisDao businessHisDao;

    @Override
    @Transactional
    public void insert(String businessId, String businessNo, int businessType, int action, Object object) {
        try {
            BusinessHis business = new BusinessHis();
            User user = LoginUtil.getUserInfo();
            String empNo = "";
            if (!StringUtils.isEmpty(user)) {
                empNo = user.getUserName();
            }
            business.setAddUser(empNo);
            business.setBusinessNo(businessNo);
            business.setContent(JsonUtil.toJson(object));
            business.setBusinessType(businessType);
            business.setBusinessId(businessId);
            business.setAction(action);
            businessHisDao.insert(business);
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. businessId：" + businessId + ",businessNo：" + businessNo + ",businessType：" + businessType, e);
        }
    }
    
    @Override
    public int count(BusinessHisSearchVo businessHis) {
        return businessHisDao.count(businessHis);
    }
    
    @Override
    public List<BusinessHisSearchVo> selectList(BusinessHisSearchVo businessHis) {
        return businessHisDao.selectList(businessHis);
    }

}
