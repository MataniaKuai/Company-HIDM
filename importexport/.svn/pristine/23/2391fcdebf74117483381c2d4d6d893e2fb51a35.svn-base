package com.hidm.importexport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.entity.BusinessHis;
import com.hidm.importexport.service.BusinessHisService;
import com.hidm.importexport.vo.BusinessHisSearchVo;
import com.hidm.importexport.vo.PaginationVo;

@Controller
public class BusinessHisController {

    @Autowired
    private BusinessHisService businessHisService;

    @RequestMapping("manage/businessHis")
    public String manageSystem(Model model, HttpSession session) {
        return "/manage/businessHis";
    }
    
    /**
     * 
    *Description: 查询操作进口信息和保税主档信息的操作历史记录信息
    *@param businessHis 要操作的业务对象
    *@param page 分页对象
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("businessHis/search")
    @ResponseBody
    public Map<String, Object> search(BusinessHis businessHis, PaginationVo page, Model model, HttpSession session) {
        BusinessHisSearchVo vo = new BusinessHisSearchVo();
        vo.setBusinessHis(businessHis);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = businessHisService.count(vo);
        List<BusinessHisSearchVo> list = businessHisService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
}
