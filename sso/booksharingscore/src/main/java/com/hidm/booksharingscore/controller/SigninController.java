package com.hidm.booksharingscore.controller;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hidm.booksharingscore.entity.Course;
import com.hidm.booksharingscore.entity.Score;
import com.hidm.booksharingscore.entity.User;
import com.hidm.booksharingscore.service.CourseService;
import com.hidm.booksharingscore.service.ScoreService;
import com.hidm.booksharingscore.service.UserService;
import com.hidm.booksharingscore.vo.ScoreVo;
import com.hidm.booksharingscore.util.SendMailUtil;



@Controller
public class SigninController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
    @Autowired
    private CourseService courseService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ScoreService scoreService;
    
	@Value("${url.path}")
	private String urlPath;
 
    @RequestMapping("signin/manage")
    public String hello(Model model, HttpSession session) throws ParseException{
    	
    	if(isValid()) {
    		return "/signin/manage";
    	}else {
    		return "/info/courseerror";
    	}
    }
    
    
    @RequestMapping("signin/search")
    @ResponseBody
    public Map<String, Object> search() {
    	
    	List<Course> list = getTodayCourse(Calendar.getInstance().getTime());
    	Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", list.get(0));
        return result;
    	
    	
    	
//    	SigninInfoSearchVo vo = new SigninInfoSearchVo();
    	
    	//获取当前时间并转换为字符串
//    	Date getDate = Calendar.getInstance().getTime();
//    	String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(getDate);
//    	vo.setNowDate(dateStr);
//    	vo.setPage(page);
//        page.setRowStart((page.getPage() - 1) * page.getRows());
//    	
//        int total = 0;
//        List<Course> list = courseService.selectTodyInfoByPage(vo);
//        if(list.size() > 0) {
//        	total = 1;
//        }
//        
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("total", total);
//        result.put("rows", list);
//        return result;
    }
    
    @RequestMapping("signin/signin")
    public String doLogin(@RequestParam(value = "userName") String userName,
        @RequestParam(value = "password") String password, Model model, HttpSession session) throws ParseException {
        
        boolean auc = false;
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.addAttribute("message", "登录失败:用户名和密码不能为空！");
        } else {
            String host = "hidmgroup.com";
            String domain = "@hidmgroup.com";
            String url = new String("ldap://" + host);
            
            Hashtable<String, Object> env = new Hashtable<String, Object>();// 实例化一个Env
            DirContext ctx = null;
            env.put(Context.SECURITY_AUTHENTICATION, "simple");// LDAP访问安全级别(none,simple,strong),一种模式，这么写就行
            env.put(Context.SECURITY_PRINCIPAL, userName + domain); // 用户名
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, url);
            try {
                ctx = new InitialDirContext(env);// 初始化上下文
                auc = true;
                log.info("登陆成功！ userName:" + userName);
            } catch (AuthenticationException e) {
                log.error("身份验证失败! userName:" + userName + ", password:" + password, e);
            } catch (javax.naming.CommunicationException e) {
                log.error("AD域连接失败! userName:" + userName + ", password:" + password, e);
            } catch (Exception e) {
                log.error("身份验证未知异常! userName:" + userName + ", password:" + password, e);
            } finally {
                if (null != ctx) {
                    try {
                        ctx.close();
                        ctx = null;
                    } catch (Exception e) {
                        log.error("AD链接关闭异常! userName:" + userName + ", password:" + password, e);
                    }
                }
            }
        }
        //用户名密码正确
        if (auc) {
        	
        	//判断当前签到时间是否在课程有效期内
        	if(isValid()) {
        		//签到成功 获取当前登陆人工号对应id 及当前时间（获取课程信息）
            	User user = new User();
            	Score score = new Score();
            	user.setUserName(userName);
            	List<User> users = userService.selectUser(user);
            	
            	List<Course> list = getTodayCourse(Calendar.getInstance().getTime());
            	if(list.size() > 0) {
            		score.setCourseId(list.get(0).getId());
            		score.setUserId(users.get(0).getId());
            		
            		//插入数据前先判断该人员是否已经签到
            		int count = scoreService.countByCidUid(score);
            		if(count > 0) {
            			return "/info/signinduplicate";
            		}else {
            			scoreService.insert(score);
            		}
            		
            	}else {
            		return "/info/courseerror";
            	}
                return "/info/logininsuccess";
        	}else {
        		return "/info/signinerror";
        	}
           
        } else {
            model.addAttribute("message", "登录失败:请检查您的用户名和密码！");
        }
        return "/signin/manage";
    }
    
    //判断当前时间是否在 beginTime, endTime之间
    private boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }
    
    //获取当日课程信息
    private List<Course> getTodayCourse(Date getDate) {
    	
    	String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(getDate);
        //查找今日课程信息 判断该课程是否失效
        List<Course> list = courseService.selectTodyInfo(dateStr);
        return list;
    }
    
    //目前访问课程时间是否在课程有效时间内
    private boolean isValid() throws ParseException {
    	
    	//获取当前时间并转换为字符串
    	Date getDate = Calendar.getInstance().getTime();

    	List<Course> list = getTodayCourse(getDate);
        if(list.size() > 0) {
        	
        	String courseStartDateStr = list.get(0).getCourseStartDate() + ":00";
        	String courseEndDateStr = list.get(0).getCourseEndDate() + ":00";
        	Date courseStartDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(courseStartDateStr);
        	Date courseEndDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(courseEndDateStr);
        	
        	//获取课程开始时间前五分钟
        	Calendar c = Calendar.getInstance();
        	c.setTime(courseStartDate);
        	c.add(Calendar.MINUTE, -5);
        	courseStartDate = c.getTime();
        	
        	//判断当前访问时间是否在课程开课时间内
        	if(belongCalendar(getDate, courseStartDate, courseEndDate)) {
        		return true;
        	}else {
        		return false;
        	}
        	
        }else {
        	return false;
        }
    }
    
    //定时发送邮件给课程当天签到人员
    //@Scheduled(cron= "0 0 17 * * ?")
    public String mailTo() throws UnsupportedEncodingException, MessagingException {
    	List<Course> courseList = getTodayCourse(Calendar.getInstance().getTime());
	    if(courseList.size() > 0) {
	    	//根据当日课程，找到当日课程签到人员
	    	List<ScoreVo>  scoreList = scoreService.selectUserByCourseId(courseList.get(0).getId());
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
				SendMailUtil.sendHtmlMail("booksharingscore@hidmgroup.com", "", to, "读书会分享评分", "请给<b> " + courseList.get(0).getTitle() + "</b> 进行评分(如已评分，请忽略)。<br />评分链接：" + urlPath);
	    	}
	    }
	    return null;
    }
    
    //手动发送邮件给课程当天签到人员
    @RequestMapping("testEmail")
    public String testEmail() throws UnsupportedEncodingException, MessagingException {
    	List<Course> courseList = getTodayCourse(Calendar.getInstance().getTime());
	    if(courseList.size() > 0) {
	    	//根据当日课程，找到当日课程签到人员
	    	List<ScoreVo>  scoreList = scoreService.selectUserByCourseId(courseList.get(0).getId());
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
						"  今日读书会分享已结束，请给" + "<b>" + courseList.get(0).getTitle() + "</b> 进行评分(如已评分，请忽略),\r\n" + "评分链接如下：" 
						+ urlPath);
				sb.append("Best Regards!\r\n" + 
						"		</pre>\r\n" + 
						"	</body>\r\n" + 
						"</html>");
				
				SendMailUtil.sendHtmlMail("booksharingscore@hidmgroup.com", "", to, "读书会分享评分", "请给<b> " + sb.toString());
	    	}
	    }
	    return null;
    }
    
    //根据课程id查询相关签到人员信息 及 未签到人员信息
    @RequestMapping("user/selectUserByCourseId")
 	@ResponseBody
 	public Map<String, Object> _selectUserByCourseId(@RequestParam("courseId") Long id) {
     	Map<String, Object> result = new HashMap<String, Object>();
     	List<Long> userIdList = new ArrayList<Long>();
     	List<User> userList = new ArrayList<User>();
     	
     	List<ScoreVo>  scoreList = scoreService.selectUserByCourseId(id);
     	if(scoreList.size() > 0) {
	    	
	    	for(int i = 0; i < scoreList.size(); i++) {
	    		userIdList.add(scoreList.get(i).getUserId());
	    	}
	    	//根据签到人员ID查询签到人员信息
	    	userList = userService.selectUserByIdList(userIdList);
    	}
     	
     	//查询未签到人员信息
     	List<User> userNoSigninList = userService.selectUser(new User());
     	for(int i = 0; i < userList.size(); i++) {
     		for(int j = 0; j < userNoSigninList.size(); j++) {
     			if(userList.get(i).getId() == userNoSigninList.get(j).getId()) {
     				userNoSigninList.remove(j);
     			}
     		}
     	}
     	
     	result.put("users", userList);
     	result.put("usersNoSignin", userNoSigninList);
 		return result;
 	}

}
