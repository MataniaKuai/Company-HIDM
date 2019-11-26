package com.hidm.coo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.constant.ReportConstant;
import com.hidm.coo.entity.User;
import com.hidm.coo.entity.UserBase;
import com.hidm.coo.service.UserBaseService;
import com.hidm.coo.util.LoginUtil;
import com.hidm.coo.vo.PaginationVo;
import com.hidm.coo.vo.UserBaseSearchVo;
import com.hidm.coo.vo.UserBaseVo;

@Controller
public class MCBaseController {

    @Autowired
    private UserBaseService userBaseService;
    
    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("mcBase/manage")
    public String index(Model model, HttpSession session) {
        return "/mc/manage";
    }
    
    @RequestMapping("mcBase/search")
    @ResponseBody
    public Map<String, Object> search(UserBase userBase, PaginationVo page, Model model, HttpSession session) {
        UserBaseSearchVo vo = new UserBaseSearchVo();
        User user = LoginUtil.getUserInfo();

        String moudule = user.getMoudule();
        String [] modules = moudule.split("/");
        if(ReportConstant.ALL.equals(moudule)) {
            modules = null;
        }
        
        userBase.setModules(modules);
        vo.setUserBase(userBase);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = userBaseService.countMc(vo);
        List<UserBaseVo> list = userBaseService.selectListMc(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }

}