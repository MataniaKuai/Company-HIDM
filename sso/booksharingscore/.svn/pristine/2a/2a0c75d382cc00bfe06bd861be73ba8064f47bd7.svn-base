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
import com.hidm.booksharingscore.service.ScoreService;
import com.hidm.booksharingscore.service.UserService;
import com.hidm.booksharingscore.util.FileUtil;
import com.hidm.booksharingscore.util.LoginUtil;
import com.hidm.booksharingscore.util.SendMailUtil;
import com.hidm.booksharingscore.vo.CourseSearchVo;
import com.hidm.booksharingscore.vo.PaginationVo;
import com.hidm.booksharingscore.vo.ScoreVo;

@Controller
public class CourseController {
	
	private String fileNameGlobal = "";
    private String filePathGlobal = "";
	
    @Value("${file.root.path}")
    private String rootPath;
    
    @Value("${url.path}")
	private String urlPath;
    
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private ScoreService scoreService;
    
    @Autowired
    private UserService userService;
 
    @RequestMapping("course/manage")
    public String hello(Model model, HttpSession session){
        return "/course/manage";
    }
    
    @RequestMapping("course/save")
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
    
    @RequestMapping("course/upload")
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Map<String, String> fileUpload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        //返回map信息；0：上传失败；1：上传成功
    	HashMap<String, String> infoMap = new HashMap<String, String>();
    	if (file.isEmpty()) {
			infoMap.put("msg", "文件为空");
			return infoMap;
		}

		FileUtil.createDir(rootPath);

		String fileOriginalName = file.getOriginalFilename();
		String fileName = fileOriginalName.substring(fileOriginalName.lastIndexOf("\\") + 1);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateNowStr = sdf.format(d);
		String destName = dateNowStr + "_" + fileName;
		String filePath = "" + destName;
		
		File dest = new File(rootPath + filePath);
		try {
			file.transferTo(dest);
			fileNameGlobal = fileName;
			filePathGlobal = "upload/" + destName;
			infoMap.put("msg", "上传成功");
			return infoMap;
		} catch (IllegalStateException e) {
			infoMap.put("msg", "上传失败");
			return infoMap;
		} catch (IOException e) {
			infoMap.put("msg", "上传失败");
			return infoMap;
		}
            
    }
    
    @RequestMapping("course/search")
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
    
    @RequestMapping("course/delete")
	@ResponseBody
	public boolean deleteSystem(@RequestParam(value = "ids[]") Long[] ids, Model model, HttpSession session) {
		courseService.deleteByIds(ids);
		return true;
	}
    
    @RequestMapping("course/startScore")
    @ResponseBody
    public boolean startScore(Course course, Model model, HttpSession session) throws UnsupportedEncodingException, MessagingException {
        
    	course.setStatus(CourseConstant.COURSE_WAITING_SCORE);
    	
    	courseService.updateStatus(course);
    	
    	//根据所选课程，找到课程签到人员 并发送签到邮件
    	List<ScoreVo>  scoreList = scoreService.selectUserByCourseId(course.getId());
    	if(scoreList.size() > 0) {
	    	List<Long> userIdList = new ArrayList<Long>();
	    	for(int i = 0; i < scoreList.size(); i++) {
	    		userIdList.add(scoreList.get(i).getUserId());
	    	}
	    	//根据签到人员ID查询签到人员邮箱
	    	List<User> userList = userService.selectUserByIdList(userIdList);
	    	String [] to = new String[userList.size()];
			for(int i = 0; i < userList.size(); i++) {
				to[i] = userList.get(i).getEmail();
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"		<meta charset=\"utf-8\">\r\n" + 
					"		<title></title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>");
			sb.append("<pre style=\"font-family:微软雅黑;\">\r\n" + 
					"Dear sir/madam,\r\n" + 
					"\r\n" + 
					"      今日读书会分享已结束，请给 " + "<b>" + course.getTitle() + "</b> 进行评分(如已评分，请忽略),\r\n" + "评分链接如下：" 
					+ urlPath + "\r\n\r\n");
			sb.append("Best Regards!\r\n" + 
					"		</pre>\r\n" + 
					"	</body>\r\n" + 
					"</html>");
			SendMailUtil.sendHtmlMail("booksharingscore@hidmgroup.com", "", to, "读书会分享评分", sb.toString());
    	}
    	
        return true;
    }
    
    @RequestMapping("course/stopScore")
    @ResponseBody
    public boolean stopScore(Course course, Model model, HttpSession session) {
        
    	//1.将课程状态更新为已评分
    	course.setStatus(CourseConstant.COURSE_SCORE);
    	courseService.updateStatus(course);
    	
    	//2.从score表中查出评价此课程的评分及评论
    	List<Score> scoreList = new ArrayList<Score>();
    	scoreList = courseService.selectAssessment(course.getId());
    	
    	//3.算出平均评分及总评论
    	double scoreAverage = 0.0, sumScore = 0.0;
    	StringBuffer sb = new StringBuffer();
    	int i;
    	int count = 0;
    	for(i = 0; i < scoreList.size(); i++) {
    		if(null != scoreList.get(i).getScore()){
    			sumScore += Double.parseDouble(scoreList.get(i).getScore());
    			count++;
    		}
    		if(null != scoreList.get(i).getComment()) {
    			sb.append((i + 1) + "." + scoreList.get(i).getComment() + "\r\n");
    		}
    	}
    	if(i == 0 || count == 0) {
    		scoreAverage = 0;
    	}else {
    		scoreAverage = sumScore / count;
    	}
    	
    	//4.保存该课程的评分及评论
    	course.setScore(String.format("%.2f", scoreAverage));
    	course.setComments(sb.toString());
    	courseService.updateAssessment(course);
        return true;
    }
    
}
