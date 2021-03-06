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
import com.hidm.coo.entity.EQtype;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.EQMouduleService;
import com.hidm.coo.service.EQtypeService;
import com.hidm.coo.vo.EQMouduleVo;
import com.hidm.coo.vo.EQtypeSearchVo;
import com.hidm.coo.vo.EQtypeVo;
import com.hidm.coo.vo.PaginationVo;
@Controller
public class EQtypeController {
    private static final Logger log = LoggerFactory.getLogger(EQtypeController.class);
    
    @Autowired
    private EQtypeService eqTypeService;
    
    @Autowired
    private BusinessHisService businessHisService;
    
    @Autowired
    private EQMouduleService eqMouduleService;

    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("eqType/manage")
    public String index(Model model, HttpSession session) {
        List<EQMouduleVo> eqMouduleList = eqMouduleService.selectAll();
        model.addAttribute("eqMouduleList", eqMouduleList);
        return "/eqtype/manage";
    }
    @RequestMapping("eqType/search")
    @ResponseBody
    public Map<String, Object> search(EQtype eQtype, PaginationVo page, Model model, HttpSession session) {
    	
        EQtypeSearchVo vo = new EQtypeSearchVo();
        vo.setEqType(eQtype);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = eqTypeService.count(vo);
        List<EQtypeVo> list = eqTypeService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }

    /**
     * 校验重复
     * @param eQtype
     * @return
     */
    @RequestMapping("eqType/checkData")
    @ResponseBody
    public Map<String, Object> checkData(EQtype eQtype) {
        EQtypeSearchVo vo = new EQtypeSearchVo();
        vo.setEqType(eQtype);
        List<EQtypeVo> list = eqTypeService.selectCheckData(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        return result;
    }
    
    /**
     * 
    *Description: 保存或更新eqType同时保存操作记录
    *@param eqType
    *@return 
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    @RequestMapping("eqType/save")
    @ResponseBody
    public String save(EQtype eQtype, Model model, HttpSession session) {
        int action;
        if (null == eQtype.getId() || 0 == eQtype.getId()) {
            eqTypeService.insert(eQtype);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
            eqTypeService.updateById(eQtype);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(eQtype.getId()), eQtype.getEqType(), 
                BusinessConstant.BUSINESS_TYPE_EQTYPE, action, eQtype);
        return "true";
    }
    
    /**
     * 
    *Description: 根据eqType的id删除记录，同时添加操作日志
    *@param ids Long[] 
    *@return boolean 
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    @RequestMapping("/eqType/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        eqTypeService.deleteByIds(ids);
        return true;
    }
    
    /**
     * 
    *Description: 记录删除的eqType信息日志
    *@param ids Long[]
    *@author yl
    *@date 2019.6.17
    *@version 1.0
     */
    public void deleteBusiness(Long[] ids) {
        try {
            List<EQtypeVo> list = eqTypeService.selectInfoByIds(ids);
            for (EQtypeVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getEqType(), 
                        BusinessConstant.BUSINESS_TYPE_EQTYPE, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. assetIds：" + ids, e);
        }
    }
}