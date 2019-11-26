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
import com.hidm.coo.entity.User;
import com.hidm.coo.service.BusinessHisService;
import com.hidm.coo.service.UserService;
import com.hidm.coo.vo.UserSearchVo;
import com.hidm.coo.vo.UserVo;
import com.hidm.coo.vo.PaginationVo;
@Controller
public class userManageController {
    private static final Logger log = LoggerFactory.getLogger(userManageController.class);
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BusinessHisService businessHisService;

    /**
     * user跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("userManage/manage")
    public String index(Model model, HttpSession session) {
        return "/userManage/manage";
    }
    @RequestMapping("userManage/search")
    @ResponseBody
    public Map<String, Object> search(User user, PaginationVo page, Model model, HttpSession session) {
    	UserSearchVo vo = new UserSearchVo();
        vo.setOthers(user);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = userService.count(vo);
        List<UserVo> list = userService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
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
    @RequestMapping("userManage/save")
    @ResponseBody
    public String save(User user, Model model, HttpSession session) {
        int action;
        if (null == user.getId() || 0 == user.getId()) {
        	userService.insert(user);
            action = BusinessConstant.BUSINESS_INSERT;
        } else {
        	userService.updateById(user);
            action = BusinessConstant.BUSINESS_UPDATE;
        }
        
        businessHisService.insert(String.valueOf(user.getId()), user.getUserName(),
                BusinessConstant.BUSINESS_TYPE_EQTYPE, action, user);
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
    @RequestMapping("/userManage/delete")
    @ResponseBody
    public boolean deleteSystem(@RequestParam(value="ids[]") Long[] ids, Model model, HttpSession session) {
        deleteBusiness(ids);
        userService.deleteByIds(ids);
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
            List<UserVo> list = userService.selectInfoByIds(ids);
            for (UserVo e : list) {
                businessHisService.insert(String.valueOf(e.getId()), e.getUserName(), 
                        BusinessConstant.BUSINESS_TYPE_EQTYPE, BusinessConstant.BUSINESS_DELETE, null);
            }
        } catch (Exception e) {
            log.error("Failed to insertBusinessHis. assetIds：" + ids, e);
        }
    }
}