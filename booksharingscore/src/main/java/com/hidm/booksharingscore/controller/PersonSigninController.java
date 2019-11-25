package com.hidm.booksharingscore.controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hidm.booksharingscore.constant.CourseConstant;
import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.CourseService;
import com.hidm.booksharingscore.util.FileUtil;
import com.hidm.booksharingscore.util.LoginUtil;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.PaginationVo;

@Controller
public class PersonSigninController {
	
	private String fileNameGlobal = "";
    private String filePathGlobal = "";
	
    @Value("${file.root.path}")
    private String rootPath;
    
    @Autowired
    private CourseService courseService;
 
    @RequestMapping("personsignin/manage")
    public String hello(Model model, HttpSession session){
        return "/personsignin/manage";
    }
    
    @RequestMapping("personsignin/save")
    @ResponseBody
    public String save(Course course, Model model, HttpSession session) {
    	//保存分两种情况：新建保存与编辑保存 后者需要考虑编辑内容时是否有重新上传文件 若未上传文件 则
    	//保持文件名和路径不变 若上传文件则更新文件名和路径
    	Course courseTmp = null;
    	if (null != course.getId()) {
    		courseTmp = courseService.selectById(course.getId());
    	}
        User user = LoginUtil.getUserInfo();
        
        //编辑时未修改文件 或新增未上传文件
        if("" == fileNameGlobal) {
        	if(null != courseTmp) {//编辑文件
        		course.setFileName(courseTmp.getFileName());
                course.setFilePath(courseTmp.getFilePath());
        	}
        }else {//新增 或 编辑时修改了上传文件
        	course.setFileName(fileNameGlobal);
            course.setFilePath(filePathGlobal);
        }
        course.setStatus(CourseConstant.COURSE_WAITING_START);
        course.setAddUser(user.getUserName());
        course.setUpdateUser(user.getUserName());
        
        if (null == course.getId()) {
        	course.setAddTime(new Date());
            courseService.insert(course);
        } else {
        	courseService.updateById(course);
        }
        
        return "true";
    }
    
    @RequestMapping("personsignin/search")
    @ResponseBody
    public Map<String, Object> search(Course course, PaginationVo page, Model model, HttpSession session) {
        CourseSearchVo vo = new CourseSearchVo();
        vo.setCourse(course);
        vo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        
        int total = courseService.count(vo);
        List<Course> list = courseService.selectList(vo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", list);
        return result;
    }
    
}
