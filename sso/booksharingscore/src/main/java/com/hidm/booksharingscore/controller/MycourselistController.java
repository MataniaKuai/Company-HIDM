package com.hidm.booksharingscore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Mycourselist;
import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.MycourselistService;
import com.hidm.booksharingscore.util.LoginUtil;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.MyCourseSearchVo;
import com.hidm.booksharingscore.vo.PaginationVo;


@Controller
public class MycourselistController {
	 @Autowired
	    private MycourselistService MycourseService;
	 @RequestMapping("mycourse/manage")
	    public String courselist(Model model, HttpSession session) {
	    	return "mycourse/manage";
	    }
	 @RequestMapping("mycourse/search")
	 @ResponseBody
	    public Map<String, Object> search(Mycourselist courses, PaginationVo page, Model model, HttpSession session) {
    	     User user = LoginUtil.getUserInfo();
            courses.setLecturerNo(user.getUserName());
	        MyCourseSearchVo vo = new MyCourseSearchVo();
	        vo.setCourse(courses);
	        vo.setEmployeeNo(user.getUserName());
	        vo.setPage(page);
	        page.setRowStart((page.getPage() - 1) * page.getRows());
	        
	        int total = MycourseService.count(vo);
	        List<Course> list = MycourseService.mycourse(vo);
	        
	        Map<String, Object> result = new HashMap<String, Object>();
	        result.put("total", total);
	        result.put("rows", list);
	        return result;
}
}
