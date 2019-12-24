package com.hidm.booksharingscore.controller;


import java.util.Date;
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

import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.CourseService;
import com.hidm.booksharingscore.service.ScoreService;
import com.hidm.booksharingscore.service.UserService;
import com.hidm.booksharingscore.util.LoginUtil;
import com.hidm.booksharingscore.vo.PaginationVo;
import com.hidm.booksharingscore.vo.UserSearchVo;



@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
 
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ScoreService scoreService;
    @RequestMapping("user/manage")
    public String hello(Model model, HttpSession session){
        return "/user/manage";
    }
    
    
    @RequestMapping("user/search")
    @ResponseBody
    public Map<String, Object> search(User user, PaginationVo page, Model model, HttpSession session) {
    	UserSearchVo vo = new UserSearchVo();
        vo.setUser(user);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = userService.count(vo);
        List<User> list = userService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
    @RequestMapping("user/save")
    @ResponseBody
    public boolean save(User user, Model model, HttpSession session) {
    	if (null == user.getId()) {
        	user.setAddTime(new Date());
            userService.insert(user);
        } else {
        	userService.updateById(user);
        }
        return true;
    }
    
    @RequestMapping("user/delete")
	@ResponseBody
	public boolean deleteSystem(@RequestParam(value = "ids[]") Long[] ids, Model model, HttpSession session) {
    	int raterCount = 0;
    	int speakerCount = 0;
    	String employeeNo = "";
    	for(int i = 0; i < ids.length; i++) {
    		User user = new User();
    		user.setId(ids[i]);
    		employeeNo = userService.selectUser(user).get(0).getUserName();
    		raterCount = scoreService.countRater(ids[i]);
    		speakerCount = courseService.countSpeaker(employeeNo);
    		if(raterCount > 0 || speakerCount > 0) {
    			return false;
    		}
    	}
    	
		userService.deleteByIds(ids);
		return true;
	}
}
