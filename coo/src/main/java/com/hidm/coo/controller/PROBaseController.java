package com.hidm.coo.controller;

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
import com.hidm.coo.entity.PROBase;
import com.hidm.coo.entity.User;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.PROBaseService;
import com.hidm.coo.service.UserService;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.PROBaseSearchVo;
import com.hidm.coo.vo.PROBaseVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.PortalUserVo;

@Controller
public class PROBaseController {

    
    @Autowired
    private PROBaseService proBaseService;
    @Autowired
    private BusinessHisService businessHisService;
    @Autowired
    private UserService userService;
    
    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("proBase/manage")
    public String index(Model model, HttpSession session) {
        User user = LoginUtil.getUserInfo();
        PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
        model.addAttribute("userName", user.getUserName() + "(" + userInfo.getUsername() + ")");
        return "/pro/manage";
    }
    /**
     * 保存User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("proBase/save")
    @ResponseBody
    public String save(PROBase proBase, Model model, HttpSession session) {
    	 proBase.setStatus(StatusConstant.INIT);
    	 proBase.setIsSubmit(StatusConstant.INIT);
         if (null == proBase.getId() || 0 == proBase.getId()) {        	
        	 proBaseService.insert(proBase);
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             proBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
        	 proBaseService.updateById(proBase);
         }
      
         proBaseService.synchToSap(proBase);
         
         return "true";
   
    }
    @RequestMapping("proBase/prosubmit")
    @ResponseBody
    public String prosubmit(PROBase proBase, Model model, HttpSession session) {
    	int action;
   	 proBase.setIsSubmit(StatusConstant.SUBMIT);
        if (null == proBase.getId() || 0 == proBase.getId()) {        	
        	 proBaseService.insert(proBase);
            action = BusinessConstant.BUSINESS_SUBMIT;
        } else {
            User user = LoginUtil.getUserInfo();
            PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
            proBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
        	proBase.setStatus(StatusConstant.SUBMIT);
       	    proBaseService.updateById(proBase);
           action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(proBase.getId()),proBase.getUserBaseId().toString(),  BusinessConstant.BUSINESS_TYPE_USERBASE, action, proBase);

        
        proBaseService.synchToSap(proBase);
        
        return "true";
    }
    
    @RequestMapping("proBase/search")
    @ResponseBody
    public Map<String, Object> search(PROBase proBase, PaginationVo page, Model model, HttpSession session) {
        PROBaseSearchVo vo = new PROBaseSearchVo();
        vo.setProBase(proBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = proBaseService.count(vo);
        List<PROBaseVo> list = proBaseService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("proBase/delete")
    @ResponseBody
    public int deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        proBaseService.deleteByIds(ids);
        return 0;
    }

}