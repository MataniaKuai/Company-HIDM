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

import com.hidm.importexport.service.ImportBatchHisService;
import com.hidm.importexport.vo.ImportBatchHisSearchVo;
import com.hidm.importexport.vo.ImportBatchHisVo;
import com.hidm.importexport.vo.PaginationVo;
  
@Controller
public class ImportBatchHisController {
    
    @Autowired
    private ImportBatchHisService importBatchHisService;

    /**
     * 
    *Description: 查询item的操作历史记录信息
    *@param itemHisId
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importBatchHis/searchByItemHis")
    @ResponseBody
    public Map<String, Object> searchByItemHis(String itemHisId, PaginationVo page, Model model, HttpSession session) {
        ImportBatchHisSearchVo vo = new ImportBatchHisSearchVo();
        vo.setPage(page);
        vo.setItemHisId(Long.parseLong(itemHisId));
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        List<ImportBatchHisVo> list = importBatchHisService.selectByItemHisId(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", list.size());
        result.put("rows", list);
        return result;
    }
}