package com.hidm.booksharingscore.controller;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hidm.booksharingscore.util.DataUtil;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Value("${serverloginURL}")
	public String serverloginURL;
    
    @Value("${targetURL}")
   	public String targetURL;
    
    @Value("${serverDecodeURL}")
   	public String serverDecodeURL;
    
    @Value("${serverlogoutURL}")
  	public String serverlogoutURL;
    
    @RequestMapping("main")
    public String index(Model model, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            model.addAttribute("islogin", true);
        } else {
            return "redirect:" + serverloginURL + "?targetURL=" + targetURL;
        }
        return "/main";
        
    }
    
    @RequestMapping("skipMain")
    public String skipMain(Model model, HttpServletRequest request, String token) throws Exception {
    	String remoteAddr = DataUtil.getIP(request);
    	String username = DataUtil.decoder(serverDecodeURL, token, remoteAddr);
    	Subject subject = SecurityUtils.getSubject();
    	if(null != username && !username.isEmpty() && !"decodeFail".equals(username)) {
    		try {
    			UsernamePasswordToken uptoken = new UsernamePasswordToken(username, "");
    			subject.login(uptoken);
    			return "redirect:/main";
    		}catch(Exception e){
    			model.addAttribute("message", "没有登陆权限");
    			return "/info/error";
    		}
    	}
    	return "redirect:" + serverloginURL + "?targetURL=" + targetURL;
    }
    
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
    	String reToken = request.getParameter("token");
    	if(null != reToken && !reToken.isEmpty()) {
    		model.addAttribute("reToken", reToken);

    		return "/view";
    	}
    	return "redirect:" + serverloginURL + "?targetURL=" + targetURL;
    }
    
//    @RequestMapping("error")
//    public String error(HttpSession session) {
//        return "/error";
//    }

    /**
     * 
    *Description: 处理用户登认证录、授权
    *@param userName 用户名（工号）
    *@param password 密码（电脑开机密码）
    *@return String 跳转页面路径，成功跳转到主页面，失败跳转到登录页面
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     */
    @RequestMapping("doLogin")
    public String doLogin(@RequestParam(value = "userName") String userName,
        @RequestParam(value = "password") String password, Model model, HttpSession session) {
        
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
        if (auc) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            subject.login(token);
            return "redirect:/main";

        } else {
            model.addAttribute("message", "登录失败:请检查您的用户名和密码！");
        }
        return "login";
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session, HttpServletResponse response) {
    	String filterUrl = serverlogoutURL + "?targetURL=" + targetURL;
    	Subject subject = SecurityUtils.getSubject();
    	subject.logout();
    	log.info("================logout success================");
    	return "redirect:" + filterUrl;
    }
    
    @RequestMapping("logoutBook")
    public void logoutBook(HttpSession session, HttpServletResponse response) {
    	Subject subject = SecurityUtils.getSubject();
    	subject.logout();
    	log.info("================logout success================");
    }
}