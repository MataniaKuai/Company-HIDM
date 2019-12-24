package com.hidm.sso.controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.sso.constant.StatusConstant;
import com.hidm.sso.util.DataUtil;
import com.hidm.sso.util.JsonUtil;

@Controller
public class FilterController {
	
	private static final Logger log = LoggerFactory.getLogger(FilterController.class);
	
	@Value("${clientURL}")
	private String clientURL;
	private HashMap<String, Subject> loginMap = new HashMap<String, Subject>();
	private HashMap<String, String> ipMap = new HashMap<String, String>();
	
    @RequestMapping("main")
    public String index(HttpServletRequest request, Model model) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            model.addAttribute("islogin", true);
        } else {
            return "redirect:/login";
        }
        model.addAttribute("userName", principal.toString());
        return "/main";
    }
	
	@RequestMapping("login")
	public String login(String targetURL, HttpServletRequest request, Model model) throws Exception {
		log.info("================start login=targetURL================" + targetURL);
		String remoteAddr = DataUtil.getIP(request);
		log.info("================SSO remoteAddr================" + remoteAddr);
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		model.addAttribute("clientURL", clientURL);
		model.addAttribute("targetURL", targetURL);
		model.addAttribute("remoteAddr", remoteAddr);
		if(null != principal) {
			if(null != targetURL && !targetURL.isEmpty()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", principal.toString());
				map.put("ip", remoteAddr);
				String myToken = Base64.getEncoder().encodeToString(JsonUtil.toJson(map).getBytes("UTF-8"));
				String tokenUrl = "?token=" + myToken;
				if(targetURL.indexOf("?") > 0) {
					tokenUrl = "&token=" + myToken;
				}
				return "redirect:" + targetURL + tokenUrl;
			}else {
				return "redirect:/main";
			}
		}
		return "/login";
	}
	
	@RequestMapping("doLogin")
	public String doLogin(@RequestParam(value = "userName") String userName, String targetURL, String remoteAddr,
			@RequestParam(value = "password") String password, Model model, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
		log.info("=========start doLogin============");
        userName = userName.toUpperCase();
        log.info("=========targetURL===========" + targetURL);
        boolean auc = false;
//        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
//            model.addAttribute("targetURL", targetURL);
//            model.addAttribute("remoteAddr", remoteAddr);
//            model.addAttribute("message", "登录失败:用户名和密码不能为空！");
//        } else {
//            String host = "hidmgroup.com";
//            String domain = "@hidmgroup.com";
//            String url = new String("ldap://" + host);
//
//            log.info("=========start check============");
//            Hashtable<String, Object> env = new Hashtable<String, Object>();// 实例化一个Env
//            DirContext ctx = null;
//            env.put(Context.SECURITY_AUTHENTICATION, "simple");// LDAP访问安全级别(none,simple,strong),一种模式，这么写就行
//            env.put(Context.SECURITY_PRINCIPAL, userName + domain); // 用户名
//            env.put(Context.SECURITY_CREDENTIALS, password);
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//            env.put(Context.PROVIDER_URL, url);
//            try {
//                ctx = new InitialDirContext(env);// 初始化上下文
//                auc = true;
//                log.info("登陆成功！ userName:" + userName);
//            } catch (AuthenticationException e) {
//                log.error("身份验证失败! userName:" + userName, e);
//            } catch (javax.naming.CommunicationException e) {
//                log.error("AD域连接失败! userName:" + userName, e);
//            } catch (Exception e) {
//                log.error("身份验证未知异常! userName:" + userName, e);
//            } finally {
//                if (null != ctx) {
//                    try {
//                        ctx.close();
//                        ctx = null;
//                    } catch (Exception e) {
//                        log.error("AD链接关闭异常! userName:" + userName, e);
//                    }
//                }
//            }
//        }
        log.info("=========checked============" + auc);
        if(true) {
        	Subject subject = SecurityUtils.getSubject();
        	UsernamePasswordToken token = new UsernamePasswordToken(userName, "");
        	subject.login(token);
    		HashMap<String, String> map = new HashMap<String, String>();
    		map.put("name", userName);
    		map.put("ip", remoteAddr);
    		String myToken = Base64.getEncoder().encodeToString(JsonUtil.toJson(map).getBytes("UTF-8"));
    		log.info("=========token============" + myToken);
    		loginMap.put(myToken, subject);
    		ipMap.put(myToken, remoteAddr);
    		String tokenUrl = "?token=" + myToken;
	    	if(null == targetURL || targetURL.isEmpty()) {
        		return "redirect:/main";
        	}else {
    			if(targetURL.indexOf("?") > 0) {
    				tokenUrl = "&token=" + myToken;
    			}
        		return "redirect:" + targetURL + tokenUrl;
        	}
        }else {
        	model.addAttribute("targetURL", targetURL);
        	model.addAttribute("remoteAddr", remoteAddr);
        	model.addAttribute("message", "登陆失败：请检查您的用户名和密码！");
        }
        return "/login";
	}
	
	@RequestMapping(value = "decodeValue")
	@ResponseBody
	public String decodeValue(HttpServletRequest request) throws UnsupportedEncodingException {
		String token = request.getParameter("token");
		String remoteAddr = request.getParameter("remoteAddr");
		if(null == token) {
			return null;
		}
		byte[] nameByte = Base64.getDecoder().decode(token);
		String myToken = new String(nameByte, "UTF-8");
		Map<String, String> parseJson = JsonUtil.parseJson(myToken, Map.class);
		log.info("================request.getRemoteAddr()================" + remoteAddr);
		
		String myIp = ipMap.get(token);
		Subject subject = loginMap.get(token);
		String principal = subject.getPrincipal().toString();
		log.info("=========subject.getPrincipal()============" + subject.getPrincipal());
	    log.info("=========principal============" + principal);
	    log.info("=========myIp===========" + myIp);
	    if(remoteAddr.equals(myIp) && principal.equals(parseJson.get("name"))) {
	    	return parseJson.get("name");
	    }
	    return StatusConstant.DECODEFail;
	}
	
	@Scheduled(cron = "0 0 1 * * ?")
	public void taskScheduled() {
		for(String key : loginMap.keySet()) {
			log.info("=========key===========");
			Subject sub = loginMap.get(key);
			try {
				String principal = sub.getPrincipal().toString();
				log.info("=========userName:===========" + principal);
			}catch(InvalidSessionException e) {
				log.info("=========Session过期===========");
				loginMap.remove(key);
				ipMap.remove(key);
			}
		}
	}
	
	@RequestMapping("logout")
	public String logout(String targetURL, HttpServletResponse response, Model model) {
		String filterUrl = "?targetURL=" + targetURL;
		log.info("=========start logout= targetURL============" + targetURL);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		model.addAttribute("clientURL", clientURL);
		model.addAttribute("targetURL", targetURL);
		if(null != targetURL && !targetURL.isEmpty()) {
			return "redirect:/login" + filterUrl;
		}
		return "/login";
	}
}
