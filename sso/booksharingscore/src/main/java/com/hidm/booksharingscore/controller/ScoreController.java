package com.hidm.booksharingscore.controller;


import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.booksharingscore.constant.CourseConstant;
import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.CourseService;
import com.hidm.booksharingscore.service.ScoreService;
import com.hidm.booksharingscore.service.UserService;
import com.hidm.booksharingscore.util.LoginUtil;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.PaginationVo;
import com.hidm.booksharingscore.vo.ScoreSearchVo;
import com.hidm.booksharingscore.vo.ScoreVo;


@Controller
public class ScoreController {

	@Autowired
    private ScoreService scoreService;
	
	@Autowired
    private CourseService courseService;
	
	@Autowired
    private UserService userService;
 
    @RequestMapping("score/manage")
    public String score(Model model, HttpSession session){
        return "/score/manage";
    }
    
    @RequestMapping("scoreResult/manage")
    public String scoreResult(Model model, HttpSession session){
        return "/scoreresult/manage";
    }
    
    @RequestMapping("score/search")
    @ResponseBody
    public Map<String, Object> search(Course course, PaginationVo page, Model model, HttpSession session) {
    	ScoreSearchVo searchVo = new ScoreSearchVo();

    	User user = LoginUtil.getUserInfo();
        List<User> users = userService.selectUser(user);
        
        searchVo.setUserId(users.get(0).getId());
        searchVo.setCourse(course);
        searchVo.setPage(page);
        page.setRowStart((page.getPage() - 1) * page.getRows());
        List<ScoreVo> scoreVo = scoreService.selectList(searchVo);
        //给分数解密
        for(int i = 0; i < scoreVo.size(); i++) {
        	if(null != scoreVo.get(i).getScore()){
        		scoreVo.get(i).setScore(decode(scoreVo.get(i).getScore().getBytes()));
        	}
        }
        
        int total = scoreService.count(searchVo);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", total);
        result.put("rows", scoreVo);
        return result;
    }
    
    @RequestMapping("score/save")
    @ResponseBody
    public boolean save(Score score, Model model, HttpSession session) {
        User user = LoginUtil.getUserInfo();
        
        //给评分加密
        score.setScore(encode(score.getScore().getBytes()));
        
        List<User> users = userService.selectUser(user);
        score.setUserId(users.get(0).getId());

        score.setAddTime(new Date());	
        scoreService.updateById(score);
        	
        return true; 
    }
    
    @RequestMapping("score/isSignin")
    @ResponseBody
    public boolean isSignin(Score score, Model model, HttpSession session) {
        User user = LoginUtil.getUserInfo();
        List<User> users = userService.selectUser(user);
        score.setUserId(users.get(0).getId());
        
        //判断该用户是否已签到，若未签到，则不允许评分
        int count = scoreService.countByCidUid(score);
        
        if(count > 0) {
        	return true;
        }else {
        	return false;
        }
    }
    
    @RequestMapping("scoreResult/search")
    @ResponseBody
    public Map<String, Object> searchResult(Course course, PaginationVo page, Model model, HttpSession session) {
        CourseSearchVo vo = new CourseSearchVo();
        course.setStatus(CourseConstant.COURSE_SCORE);
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
    
    @RequestMapping("score/saveSigninInfo")
    @ResponseBody
    public boolean saveSigninInfo(@RequestParam(value = "courseId") Long courseId,
    		@RequestParam(value = "pickValues") String pickValues) {
        
    	//在保存签到信息数据前，先将该课程在score表中的所有记录删除 然后再重新插入
    	scoreService.deleteByCourseId(courseId);
    	
    	//重新插入该课程的签到人员信息
    	String[] signinArray = pickValues.split(",");
    	List<String> signinList = CollectionUtils.arrayToList(signinArray);
    	List<User> userList = userService.selectUserByEmployeeNoList(signinList);
    	List<Score> scoreList = new ArrayList<Score>();
    	if(userList.size() > 0) {
	    	for(int i = 0; i < userList.size(); i++) {
	    		Score score = new Score();
	    		score.setCourseId(courseId);
	    		score.setUserId(userList.get(i).getId());
	    		score.setAddTime(new Date());
	    		scoreList.add(score);
	    	}
	    	
	    	scoreService.insertScoreList(scoreList);
    	}
        	
        return true; 
    }
    
   //base64 解码
    public static String decode(byte[] bytes) {  
        return new String(Base64.getDecoder().decode(bytes));  
    }  
  
    //base64 编码
    public static String encode(byte[] bytes) {  
        return new String(Base64.getEncoder().encode(bytes));  
    }  

}