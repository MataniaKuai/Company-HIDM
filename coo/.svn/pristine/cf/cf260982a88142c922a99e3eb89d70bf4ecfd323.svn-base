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
import com.hidm.coo.entity.MFGBase;
import com.hidm.coo.entity.Others;
import com.hidm.coo.entity.User;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.IEBaseService;
import com.hidm.coo.service.MFGBaseService;
import com.hidm.coo.service.OthersService;
import com.hidm.coo.service.UserService;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.MFGBaseSearchVo;
import com.hidm.coo.vo.MFGBaseVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.PortalUserVo;

@Controller
public class MFGBaseController {

    
    @Autowired
    private MFGBaseService mfgBaseService;
    @Autowired
    private BusinessHisService businessHisService;
    
    @Autowired
    private OthersService othersService;
    
    @Autowired
    private IEBaseService ieBaseService;
    @Autowired
    private UserService userService;
    
    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("mfgBase/manage")
    public String index(Model model, HttpSession session) {

        User user = LoginUtil.getUserInfo();
        PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
        model.addAttribute("userName", user.getUserName() + "(" + userInfo.getUsername() + ")");
        return "/mfg/manage";
    }
    /**
     * 保存User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("mfgBase/mfgsubmit")
    @ResponseBody
    public String mfgsubmit(MFGBase mfgBase, Model model, HttpSession session) {
        mfgBase.setIsSubmit(StatusConstant.SUBMIT);
    	 int action;
         if (null == mfgBase.getId() || 0 == mfgBase.getId()) {
        	 mfgBaseService.insert(mfgBase);
             action = BusinessConstant.BUSINESS_INSERT;
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             mfgBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
             action = BusinessConstant.BUSINESS_UPDATE;
   
        	 mfgBaseService.updateById(mfgBase);
         }
         
         businessHisService.insert(String.valueOf(mfgBase.getId()),mfgBase.getUserBaseId().toString(), 
                 BusinessConstant.BUSINESS_TYPE_USERBASE, action, mfgBase);
         
         mfgBaseService.synchToSap(mfgBase);
         
       //调用5号接口 获取sap传回的ex_olCost
         Others other;
    	 other=othersService.selectByName("Operate Labor Salary");
    	 BigDecimal operateLaborSalary=new BigDecimal(other.getValue());
    	 mfgBase.setOperateLaborSalary(operateLaborSalary);
    	 
    	 other=othersService.selectByName("Maintain Labor Salary");
    	 BigDecimal maintainLaborSalary=new BigDecimal(other.getValue());
    	 mfgBase.setMaintainLaborSalary(maintainLaborSalary);
    	 
    	 other=othersService.selectByName("Floor Cost_Fix");
    	 BigDecimal floorCost=new BigDecimal(other.getValue());
    	 mfgBase.setFloorCost(floorCost);
    	 
    	 BigDecimal housing=new BigDecimal(mfgBase.getHousing());
    	 mfgBase.setFloorCostAcount(floorCost.multiply(housing));
    	 MFGBase mb = mfgBaseService.synchToSap2(mfgBase);
    	 IEBase ib = new IEBase();
    	 ib.setUserBaseId(mb.getUserBaseId());
    	 ib.setOperateLaborCost(mb.getOperateLaborCost());
    	 ieBaseService.updateByUserBaseId(ib);
         return "true";
   
    }
    
    @RequestMapping("mfgBase/save")
    @ResponseBody
    public String save(MFGBase mfgBase, Model model, HttpSession session) {
    	 mfgBase.setIsSubmit(StatusConstant.INIT);
         if (null == mfgBase.getId() || 0 == mfgBase.getId()) {       	
        	 mfgBaseService.insert(mfgBase);
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             mfgBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
             mfgBase.setStatus(StatusConstant.SUBMIT);
        	 mfgBaseService.updateById(mfgBase);
         }

         mfgBaseService.synchToSap(mfgBase);
         
       //调用5号接口 获取sap传回的ex_olCost
         Others other;
    	 other=othersService.selectByName("Operate Labor Salary");
    	 BigDecimal operateLaborSalary=new BigDecimal(other.getValue());
    	 mfgBase.setOperateLaborSalary(operateLaborSalary);
    	 
    	 other=othersService.selectByName("Maintain Labor Salary");
    	 BigDecimal maintainLaborSalary=new BigDecimal(other.getValue());
    	 mfgBase.setMaintainLaborSalary(maintainLaborSalary);
    	 
    	 other=othersService.selectByName("Floor Cost_Fix");
    	 BigDecimal floorCost=new BigDecimal(other.getValue());
    	 mfgBase.setFloorCost(floorCost);
    	 
    	 BigDecimal housing=new BigDecimal(mfgBase.getHousing());
    	 mfgBase.setFloorCostAcount(floorCost.multiply(housing));
    	 MFGBase mb = mfgBaseService.synchToSap2(mfgBase);
         return "true";
   
    }
    
    @RequestMapping("mfgBase/search")
    @ResponseBody
    public Map<String, Object> search(MFGBase mfgBase, PaginationVo page, Model model, HttpSession session) {
        MFGBaseSearchVo vo = new MFGBaseSearchVo();
        vo.setMfgBase(mfgBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = mfgBaseService.count(vo);
        List<MFGBaseVo> list = mfgBaseService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("mfgBase/delete")
    @ResponseBody
    public int deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
    	mfgBaseService.deleteByIds(ids);
        return 0;
    }

}