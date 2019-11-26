package com.hidm.coo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.constant.BusinessConstant;
import com.hidm.coo.entity.ModelType;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.ModelService;
import com.hidm.coo.vo.ModelSearchVo;
import com.hidm.coo.vo.ModelVo;
import com.hidm.coo.vo.PaginationVo;
@Controller
public class ModelController {
    private static final Logger log = LoggerFactory.getLogger(ModelController.class);
    
    @Autowired
    private ModelService modelService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * vendor跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("model/manage")
    public String index(Model model, HttpSession session) {
        return "/model/manage";
    }
    @RequestMapping("model/search")
    @ResponseBody
    public Map<String, Object> search(ModelType modelType, PaginationVo page, Model model, HttpSession session) {
    	
        ModelSearchVo vo = new ModelSearchVo();
        vo.setModel(modelType);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = modelService.count(vo);
        List<ModelVo> list = modelService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }

    @RequestMapping("model/checkData")
    @ResponseBody
    public Map<String, Object> search(ModelType modelType) {
        ModelSearchVo vo = new ModelSearchVo();
        vo.setModel(modelType);
        List<ModelVo> list = modelService.selectCheckData(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        return result;
    }
    
    /**
     * 
    *Description: 保存或更新eqType同时保存操作记录
    *@param vendor
    *@return 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    @RequestMapping("model/save")
    @ResponseBody
    public String save(ModelType modelType, Model model, HttpSession session) {
        int action;
        if (null == modelType.getId() || 0 == modelType.getId()) {
        	List<ModelVo> modelVoList = modelService.selectList(null);
        	if(modelVoList.size() == 0) {
        		modelType.setModelNo("10000001");
        	}else {
        		long temp = Long.parseLong(modelVoList.get(0).getModelNo());
        		temp += 1;
        		modelType.setModelNo(temp + "");
        	}
        	modelService.insert(modelType);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
        	modelService.updateById(modelType);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(modelType.getId()), modelType.getModel(), 
                BusinessConstant.BUSINESS_TYPE_MODEL, action, modelType);
        return "true";
    }
    
    /**
     * 
    *Description: 根据eqType的id删除记录，同时添加操作日志
    *@param ids Long[] 
    *@return boolean 
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    @RequestMapping("model/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        modelService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 记录删除的eqType信息日志
    *@param ids Long[]
    *@author kmd
    *@date 2019.7.1
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<ModelVo> list = modelService.selectInfoByIds(ids);
            for (ModelVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getModel(), 
                        BusinessConstant.BUSINESS_TYPE_MODEL, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. modelIds：" + ids, e);
        }
    }
}