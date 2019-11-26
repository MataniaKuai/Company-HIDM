package com.hidm.coo.controller;

import java.math.BigDecimal;
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

import com.hidm.coo.constant.BusinessConstant;
import com.hidm.coo.constant.StatusConstant;
import com.hidm.coo.entity.IEBase;
import com.hidm.coo.entity.Others;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.IEBaseService;
import com.hidm.coo.service.OthersService;
import com.hidm.coo.vo.IEBaseSearchVo;
import com.hidm.coo.vo.IEBaseVo;
import com.hidm.coo.vo.PaginationVo;

@Controller
public class IEBaseController {

    
    @Autowired
    private IEBaseService ieBaseService;
    @Autowired
    private OthersService othersService;
    @Autowired
    private BusinessHisService businessHisService;
    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("ieBase/manage")
    public String index(Model model, HttpSession session) {
        return "/ie/manage";
    }
    
    /**
     * 保存User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("ieBase/save")
    @ResponseBody
    public String save(IEBase ieBase, Model model, HttpSession session) {
    	 int action;
         if (null == ieBase.getId() || 0 == ieBase.getId()) {
        	 ieBase.setStatus(StatusConstant.INIT);
        	 ieBaseService.insert(ieBase);
             action = BusinessConstant.BUSINESS_INSERT;
         } else {
        	 ieBase.setStatus(StatusConstant.SUBMIT);
        	 Others other;
        	 other=othersService.selectByName("Operate Labor Salary");
        	 BigDecimal operateLaborSalary=new BigDecimal(other.getValue());
        	 ieBase.setOperateLaborSalary(operateLaborSalary);
        	 
        	 other=othersService.selectByName("Maintain Labor Salary");
        	 BigDecimal maintainLaborSalary=new BigDecimal(other.getValue());
        	 ieBase.setMaintainLaborSalary(maintainLaborSalary);
        	 
        	 other=othersService.selectByName("Floor Cost_Fix");
        	 BigDecimal floorCost=new BigDecimal(other.getValue());
        	 ieBase.setFloorCost(floorCost);
        	 
        	 BigDecimal housing=new BigDecimal(ieBase.getHousing());
        	 ieBase.setFloorCostAcount(floorCost.multiply(housing));
        	 
        	 ieBaseService.updateById(ieBase);
             action = BusinessConstant.BUSINESS_UPDATE;
         }                  
         businessHisService.insert(String.valueOf(ieBase.getId()),ieBase.getUserBaseId().toString(), 
                 BusinessConstant.BUSINESS_TYPE_USERBASE, action, ieBase);
         
         //ieBaseService.synchToSAP(ieBase.getUserBaseId());
         
         //ieBaseService.synchToSap(ieBase);
         return "true";
   
    }
    
    @RequestMapping("ieBase/search")
    @ResponseBody
    public Map<String, Object> search(IEBase ieBase, PaginationVo page, Model model, HttpSession session) {
        IEBaseSearchVo vo = new IEBaseSearchVo();
        vo.setIeBase(ieBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = ieBaseService.count(vo);
        List<IEBaseVo> list = ieBaseService.selectList(vo);
        Others other1=othersService.selectByName("Operate Labor Salary");
        BigDecimal operateLaborSalary=new BigDecimal(other1.getValue());
        
        Others other2=othersService.selectByName("Maintain Labor Salary");
        BigDecimal maintainLaborSalary=new BigDecimal(other2.getValue());
        
        Others other3=othersService.selectByName("Floor Cost_Fix");
        BigDecimal floorCost=new BigDecimal(other3.getValue());
        for(IEBaseVo ie : list) {
            ie.setOperateLaborSalary(operateLaborSalary);
            ie.setMaintainLaborSalary(maintainLaborSalary);
            ie.setFloorCost(floorCost);
            if(ie.getHousing() != null && floorCost != null) {
                ie.setFloorCostAcount(floorCost.multiply(new BigDecimal(ie.getHousing())));
            }
        }
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("ieBase/delete")
    @ResponseBody
    public int deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
    	ieBaseService.deleteByIds(ids);
        return 0;
    }

}