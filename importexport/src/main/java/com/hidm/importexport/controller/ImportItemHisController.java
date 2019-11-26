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

import com.hidm.importexport.service.ImportItemHisService;
import com.hidm.importexport.vo.ImportItemHisSearchVo;
import com.hidm.importexport.vo.ImportItemHisVo;
import com.hidm.importexport.vo.PaginationVo;
  
/**
 * 
*Description: 处理item的操作日志记录
*@author GuoRong
*@date 2018年11月29日
*@version 1.0
*
 */
@Controller
public class ImportItemHisController {
    
    @Autowired
    private ImportItemHisService importItemHisService;

    /**
     * 
    *Description: 查询item历史记录信息
    *@param itemId
    *@param page
    *@return Map<String, Object> "total"为记录的总数量，"rows"为行记录对象的list集合
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("importItemHis/searchByItem")
    @ResponseBody
    public Map<String, Object> search(String itemId, PaginationVo page, Model model, HttpSession session) {
        ImportItemHisSearchVo vo = new ImportItemHisSearchVo();
        vo.setPage(page);
        vo.setItemId(Long.parseLong(itemId));
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int count = importItemHisService.countByItemId(vo);
        List<ImportItemHisVo> list = importItemHisService.selectByItemId(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", count);
        result.put("rows", list);
        return result;
    }
}