package com.hidm.importexport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.importexport.entity.InOut;
import com.hidm.importexport.service.InOutService;
import com.hidm.importexport.vo.InOutSearchVo;
import com.hidm.importexport.vo.InOutVo;
import com.hidm.importexport.vo.PaginationVo;

/**
 * 
*Description: 处理进出口业务
*@author GuoRong
*@date 2018年12月3日
*@version 1.0
*
 */
@Controller
public class InOutController {
    
    @Autowired
    private InOutService inoutService;
    
    /**
     * 
    *Description: 将请求转发到指定页面
    *@return String 页面跳转路径
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("inout/manage")
    public String manageSystem(Model model, HttpSession session) {
        return "/inout/manage";
    }
    
    /**
     * 
    *Description: 查询进出口记录
    *@param inout 进出口对象
    *@param page 分页对象
    *@return Map<String, Object> "total"为记录的数量，"rows"为记录的对象集合
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("inout/search")
    @ResponseBody
    public Map<String, Object> search(InOut inout, PaginationVo page, Model model, HttpSession session) {
        InOutSearchVo vo = new InOutSearchVo();
        vo.setInout(inout);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = inoutService.count(vo);
        List<InOutVo> list = inoutService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    /**
     * 
    *Description: 新增或更新记录
    *@param inout 进出口对象
    *@return String 操作结果状态
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("inout/save")
    @ResponseBody
    public String save(InOut inout, Model model, HttpSession session) {
        if (null == inout.getId() || 0 == inout.getId()) {
            inoutService.insert(inout);
        } else {
            inoutService.updateById(inout);
        }
        
        return "true";
    }
    
    /**
     * 
    *Description: 根据主键删除记录
    *@param ids Long[] 
    *@return boolean
    *@author GuoRong
    *@date 2018年12月3日
    *@version 1.0
     */
    @RequestMapping("inout/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        inoutService.deleteByIds(ids);
        return true;
    }

}