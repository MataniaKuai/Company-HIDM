package com.hidm.coo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.UtilityDao;
import com.hidm.coo.entity.Utility;
import com.hidm.coo.service.UtilityService;
import com.hidm.coo.util.SAPConn;
import com.hidm.coo.vo.UtilitySearchVo;
import com.hidm.coo.vo.UtilityVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "utilityService")
public class UtilityServiceImpl implements UtilityService {
	private static Logger log = Logger.getLogger(UtilityServiceImpl.class);
    @Autowired
    private UtilityDao utilityDao;
    @Autowired
    private SAPConn sapConService;



    @Override
    public int insert(Utility utility) {
        return utilityDao.insert(utility);
    }

    @Override
    public void updateById(Utility utility) {
        utilityDao.updateById(utility);
    }

    @Override
    public int count(UtilitySearchVo utilityVO) {
        return utilityDao.count(utilityVO);
    }

    @Override
    public List<UtilityVo> selectList(UtilitySearchVo utilityVO) {
        return utilityDao.selectList(utilityVO);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        utilityDao.deleteByIds(ids);
    }

    @Override
    public List<UtilityVo> selectAll() {
        return utilityDao.selectAll();
    }

    @Override
    public List<UtilityVo> selectInfoByIds(Long[] ids) {
        return utilityDao.selectInfoByIds(ids);
    }


	@Override
	public ArrayList<UtilityVo> selectByUtilityNo(String utility) {
		
		return utilityDao.selectByUtiltyNo(utility);
	}

    @Override
    public List<UtilityVo> selectInfoByUtilityNo(UtilityVo utilityVo){
    	return utilityDao.selectInfoByUtilityNo(utilityVo);
    }

    @Override
    public List<UtilityVo> selectCheckData(UtilitySearchVo vo) {
        return utilityDao.selectCheckData(vo);
    }
	@Override
	@Transactional
	public Map<String, String> getUtilityPrice(List<UtilityVo> list) {
        Map<String, String> map = new HashMap<String, String>();
		JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZCOO_SAPTOJAVA_006");
            JCoParameterList input = function.getTableParameterList();
            JCoTable t = input.getTable("T_MATNR");
            for(UtilityVo utility : list) {
                t.appendRow();
                t.setValue("MATNR", utility.getUtilityNo());
            }
            //连接SAP接口前，先打印input的信息
            log.info("begin to call SAP to get utilityprice description." + input.toXML());
            function.execute(destination);
            
            boolean success = false;
            table = function.getTableParameterList().getTable("T_MESSAGE");
            table.firstRow();
            for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) 
            {
                String ok = table.getString("ZIS_OK");
                if ("S".equals(ok)) {
                    success = true;
                } else {
                    String message = table.getString("MSG");
                    log.error("ok:" + ok + ", message:" + message);
                }
            }
            
            if (success) {
                table = function.getTableParameterList().getTable("T_DATA");
                
                //连接SAP接口成功后，显示table信息
                log.info("success to call SAP to get utilityprice description." + table.toXML());
                
                table.firstRow();
                for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {
                	String utilityprice = table.getString("STPRS");
                    String utilityNo = table.getString("MATNR");
                    map.put(utilityNo, utilityprice);
                    log.info("UtilityNo:"+utilityNo+"---utilityprice:" + utilityprice);
                }
            }
        } catch (Exception e) {
            log.error("Failed to utilityprice.", e);
            throw new RuntimeException(e);
        }
		return map;

	}

    @Override
    public List<UtilityVo> selectInfoByNos(String[] utilityNameArr) {
        return utilityDao.selectInfoByNos(utilityNameArr);
    }

}
