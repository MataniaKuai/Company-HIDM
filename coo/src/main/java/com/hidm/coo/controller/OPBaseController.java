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
import com.hidm.coo.entity.OPBase;
import com.hidm.coo.entity.User;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.OPBaseService;
import com.hidm.coo.service.UserService;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.OPBaseSearchVo;
import com.hidm.coo.vo.OPBaseVo;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.PortalUserVo;

@Controller
public class OPBaseController {

    
    @Autowired
    private OPBaseService opBaseService;
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
    @RequestMapping("opBase/manage")
    public String index(Model model, HttpSession session) {

        User user = LoginUtil.getUserInfo();
        PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
        model.addAttribute("userName", user.getUserName() + "(" + userInfo.getUsername() + ")");
        return "/op/manage";
    }
    /**
     * 保存User输入的信息
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("opBase/save")
    @ResponseBody
    public String save(OPBase opBase, Model model, HttpSession session) {
    	   opBase.setIsSubmit(StatusConstant.INIT);
         if (null == opBase.getId() || 0 == opBase.getId()) {        	
        	 opBaseService.insert(opBase);
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             opBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
        	 opBase.setStatus(StatusConstant.SUBMIT);
        	 opBaseService.updateById(opBase);
         }
       
         //opBaseService.synchToSap(opBase);
        
         return "true";
    }
    
    /**
     * 计算数据
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("opBase/costValue")
    @ResponseBody
    public OPBase costValue(OPBase opBase) {
         OPBase opBase2 = opBaseService.synchToSap(opBase);
         return opBase2;
    }
    
    @RequestMapping("opBase/opsubmit")
    @ResponseBody
    public String submit(OPBase opBase, Model model, HttpSession session) {    	
    	opBase.setIsSubmit(StatusConstant.SUBMIT);
    	 int action;
         if (null == opBase.getId() || 0 == opBase.getId()) {
        	 opBaseService.insert(opBase);
             action = BusinessConstant.BUSINESS_INSERT;
         } else {
             User user = LoginUtil.getUserInfo();
             PortalUserVo userInfo = userService.getUserInfoByEmployeeNo(user.getUserName());
             opBase.setUpdateUserId(user.getUserName() + "(" + userInfo.getUsername() + ")");
        	 opBase.setStatus(StatusConstant.SUBMIT);
        	 opBaseService.updateById(opBase);
             action = BusinessConstant.BUSINESS_UPDATE;
         }
         
         businessHisService.insert(String.valueOf(opBase.getId()),opBase.getUserBaseId().toString(), 
                 BusinessConstant.BUSINESS_TYPE_USERBASE, action, opBase);
         
         //opBaseService.synchToSap(opBase);
         //ieBaseService.synchToSAP(opBase.getUserBaseId());
         
         return "true";
   
    }
    
    @RequestMapping("opBase/search")
    @ResponseBody
    public Map<String, Object> search(OPBase opBase, PaginationVo page, Model model, HttpSession session) {
        OPBaseSearchVo vo = new OPBaseSearchVo();
        vo.setOpBase(opBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = opBaseService.count(vo);
        List<OPBaseVo> list = opBaseService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("opBase/delete")
    @ResponseBody
    public int deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
    	opBaseService.deleteByIds(ids);
        return 0;
    }

}