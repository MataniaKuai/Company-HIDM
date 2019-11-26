package com.hidm.sso.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.sso.constant.StatusConstant;
import com.hidm.sso.entity.UserInfo;
import com.hidm.sso.service.UserInfoService;
import com.hidm.sso.util.DataUtil;
import com.hidm.sso.util.JsonUtil;

@Controller
public class FilterController {

    private static final Logger log = LoggerFactory.getLogger(FilterController.class);

    @Value("${clientURL}")
    private String clientURL;
    private String loginName;
    
    @Autowired
    private UserInfoService userInfoService;

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
    /**
     * 登录验证
     * @param targetURL
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("login")
    public synchronized String login(String targetURL, HttpServletRequest request, Model model, String logout) throws Exception {
        log.info("=========start login= targetURL============" + targetURL);

        String remoteAddr = DataUtil.getIP(request);
        String remoteUser = request.getRemoteUser();
        //String remoteUser = "HIDMGROUP\\E101157";
        log.info("=========getRemoteUser============" + remoteUser);
        String userName = "";
        if(remoteUser != null && !remoteUser.isEmpty()) {
            if(remoteUser.indexOf("\\") > 0) {
                String[] split = remoteUser.split("\\\\");
                userName = split[1];
            }else {
                userName = remoteUser;
            }
        }
        loginName = userName;
        log.info("=========userName============" + userName);
        if(logout == null && !userName.isEmpty()) {
            List<UserInfo> user = userInfoService.selectUser(userName);
            if(user != null && user.size() > 0) {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(userName, "");
                subject.login(token);
                if(targetURL != null && !targetURL.isEmpty()) {
                    HashMap<String,String> map = new HashMap<String,String>();
                    map.put("name", userName);
                    map.put("ip", remoteAddr);
                    String enUsername = Base64.getEncoder().encodeToString(JsonUtil.toJson(map).getBytes("UTF-8"));
                    String tokenUrl = "?token=" + enUsername;
                    if(targetURL.indexOf("?") > 0) {
                        tokenUrl = "&token=" + enUsername;
                    }
                    return "redirect:" + targetURL + tokenUrl;
                }else {
                    return "redirect:/main";
                }
            }
        }
        model.addAttribute("clientURL", clientURL);
        model.addAttribute("targetURL", targetURL);
        model.addAttribute("remoteAddr", remoteAddr);
        return "/login";
    }

    /**
     * SSO注销入口
     * @param targetURL
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("logout")
    public synchronized String logout(String targetURL, HttpServletResponse response, Model model) throws Exception {
        String filterUrl = "?logout=true&targetURL=" + targetURL;
        log.info("=========start logout= targetURL============" + targetURL);
        //DataUtil.deleteFile(authenticationFile + macAddress + ".txt");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("clientURL", clientURL);
        model.addAttribute("targetURL", targetURL);
        //区分是直接访问当前系统还是通过其他系统重定向过来的
        if(targetURL != null && !targetURL.isEmpty()) {
            return "redirect:/login" + filterUrl;
        }
        return "/login";
    }

    /**
     * 
    *Description: 处理用户登认证录、授权
    *@param userName 用户名（工号）
    *@param password 密码（电脑开机密码）
    *@return String 跳转页面路径，成功跳转到主页面，失败跳转到登录页面
    *@author GuoRong
    *@date 2018年11月29日
    *@version 1.0
     * @throws Exception 
     */
    @RequestMapping("doLogin")
    public synchronized String doLogin(@RequestParam(value = "userName") String userName, String targetURL, String remoteAddr,
        @RequestParam(value = "password") String password, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
        log.info("=========start doLogin============");
        userName = userName.toUpperCase();
        boolean auc = false;
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
            model.addAttribute("targetURL", targetURL);
            model.addAttribute("remoteAddr", remoteAddr);
            model.addAttribute("message", "登录失败:用户名和密码不能为空！");
        } else {
            UserInfo userInfo = new UserInfo();
            userInfo.setPassWord(password);
            userInfo.setUserName(userName);
            List<UserInfo> list = userInfoService.selectUserByUsePwd(userInfo);
            if(list != null && list.size() > 0) {
                auc = true;
            }
        }
        log.info("=========checked============" + auc);
        if (auc) {
            loginName = userName;
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, "");
            subject.login(token);
            if(targetURL == null || targetURL.isEmpty()) {
                return "redirect:/main";
            }else {
                HashMap<String,String> map = new HashMap<String,String>();
                map.put("name", userName);
                map.put("ip", remoteAddr);
                String enUsername = Base64.getEncoder().encodeToString(JsonUtil.toJson(map).getBytes("UTF-8"));
                log.info("=========token============" + enUsername);
                String tokenUrl = "?token=" + enUsername;
                if(targetURL.indexOf("?") > 0) {
                    tokenUrl = "&token=" + enUsername;
                }
                return "redirect:" + targetURL + tokenUrl;
            }
        } else {
            model.addAttribute("targetURL", targetURL);
            model.addAttribute("remoteAddr", remoteAddr);
            model.addAttribute("message", "登录失败:请检查您的用户名和密码！");
        }
        return "login";
    }
    
    /**
     * 解密token，验证ip是否正确，用户名是否在session存在
     * @param request
     * @param token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "decodeValue")
    @ResponseBody
    public synchronized String decodeValue(HttpServletRequest request) throws Exception{
        String token = request.getParameter("token");
        String remoteAddr = request.getParameter("remoteAddr");
        if(null == token) {
            return null;
        }
        //解密
        byte[] nameByte = Base64.getDecoder().decode(token);
        String deUsername = new String(nameByte,"UTF-8");
        Map<String,String> parseJson = JsonUtil.parseJson(deUsername, Map.class);
        //String remoteAddr = DataUtil.getIP(request);
        log.info("=========request.getRemoteAddr()============" + remoteAddr);
        log.info("=========parseJson.get(ip)============" + parseJson.get("ip"));

        Subject subject = SecurityUtils.getSubject();
        //String principal = subject.getPrincipal().toString();
        if(remoteAddr.equals(parseJson.get("ip")) && loginName.equals(parseJson.get("name"))) {
            //return callback + "('" + parseJson.get("name") + "');";
            return parseJson.get("name");
        }
        //return callback + "('" + StatusConstant.DECODEFail + "');";
        return StatusConstant.DECODEFail;
    }

    /**
     * CS端获取token
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("getUser")
    @ResponseBody
    public synchronized String getUser(HttpServletRequest request) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        if (principal != null) {
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("name", principal.toString());
            map.put("ip", DataUtil.getIP(request));
            log.info("=========getUser ip：============" + DataUtil.getIP(request));
            String enUsername = Base64.getEncoder().encodeToString(JsonUtil.toJson(map).getBytes("UTF-8"));
            return enUsername;
        } else {
            return "";
        }
    }
}