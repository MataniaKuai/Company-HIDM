package com.hidm.coo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hidm.coo.dao.MaterialCoefficientDao;
import com.hidm.coo.entity.MaterialCoefficient;
import com.hidm.coo.service.MaterialCoefficientService;
import com.hidm.coo.util.SAPConn;
import com.hidm.coo.vo.MaterialCoefficientSearchVo;
import com.hidm.coo.vo.MaterialCoefficientVo;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

@Service(value = "materialCoefficientService")
public class MaterialCoefficientServiceImpl implements MaterialCoefficientService {
	private static Logger log = Logger.getLogger(MaterialCoefficientServiceImpl.class);
    @Autowired
    private MaterialCoefficientDao materialCoefficientDao;
    @Autowired
    private SAPConn sapConService;


    @Override
    public int insert(MaterialCoefficient materialCoefficient) {
        return materialCoefficientDao.insert(materialCoefficient);
    }

    @Override
    @Transactional
    public void updateById(MaterialCoefficient materialCoefficient) {
        materialCoefficientDao.updateById(materialCoefficient);
    }

    @Override
    public int count(MaterialCoefficientSearchVo materialCoefficientVO) {
        return materialCoefficientDao.count(materialCoefficientVO);
    }

    @Override
    public List<MaterialCoefficientVo> selectList(MaterialCoefficientSearchVo materialCoefficientVO) {
        return materialCoefficientDao.selectList(materialCoefficientVO);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        materialCoefficientDao.deleteByIds(ids);
    }

    @Override
    public List<MaterialCoefficientVo> selectAll() {
        return materialCoefficientDao.selectAll();
    }

    @Override
    public List<MaterialCoefficientVo> selectInfoByIds(Long[] ids) {
        return materialCoefficientDao.selectInfoByIds(ids);
    }


	@Override
	public ArrayList<MaterialCoefficientVo> selectByMaterialNo(String materialNo) {
		// TODO Auto-generated method stub
		return materialCoefficientDao.selectByMaterialNo(materialNo);
	}

    
    @Override
    public List<MaterialCoefficientVo> selectInfoByMaterialNo(MaterialCoefficientVo materialCoefficientVo){
    	return materialCoefficientDao.selectInfoByMaterialNo(materialCoefficientVo);
    }

    @Override
    public List<MaterialCoefficientVo> selectCheckData(MaterialCoefficientSearchVo vo) {
        return materialCoefficientDao.selectCheckData(vo);
    }

	@Override
    @Transactional
	public Map<String, String> getMatrialPrice(List<MaterialCoefficientVo> list) {
		Map<String, String> map = new HashMap<String, String>();
		JCoFunction function = null;
        JCoDestination destination = sapConService.connect();
        JCoTable table = null;
        try {
            function = destination.getRepository().getFunction("ZCOO_SAPTOJAVA_006");
            JCoParameterList input = function.getTableParameterList();
            JCoTable t = input.getTable("T_MATNR");
            for(MaterialCoefficientVo coeff : list) {
                t.appendRow();
                t.setValue("MATNR", coeff.getMaterialNo());
            }
            //连接SAP接口前，先打印input的信息
            log.info("begin to call SAP to get MatrialPrice description." + input.toXML());
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
                log.info("success to call SAP to get asset description." + table.toXML());
                
                table.firstRow();
                for (int i = 0; i < table.getNumRows(); i++, table.nextRow()) {     
                	String matrialprice = table.getString("STPRS"); 
                	String matrialNo = table.getString("MATNR");
                	map.put(matrialNo, matrialprice);
                    log.info("materialNo:"+matrialNo+"---MatrialPrice:" + matrialprice);
                }
            }
        } catch (Exception e) {
            log.error("Failed to MatrialPrice.", e);
            throw new RuntimeException(e);
        }
		return map;
	}

    @Override
    public List<MaterialCoefficientVo> selectInfoByNos(String[] materialNameArr) {
        return materialCoefficientDao.selectInfoByNos(materialNameArr);
    }  
}
