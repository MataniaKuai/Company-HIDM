package com.hidm.coo.security;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hidm.coo.entity.Permission;
import com.hidm.coo.entity.Role;
import com.hidm.coo.service.PermissionService;
import com.hidm.coo.service.RoleService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;

@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     *
     */
    
    @Autowired
    private CustomRealm customRealm;

    private LogoutFilter logoutFilter = new LogoutFilter();
    
    @Autowired
    private PermissionService permissionService;
    
    @Autowired
    private RoleService roleService;
    
    @Bean
    public ShiroFilterFactoryBean shirFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/main");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/**/vendors/**", "anon");
        filterChainDefinitionMap.put("/doLogin", "anon");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        
        logoutFilter.setRedirectUrl("/login");
        shiroFilterFactoryBean.getFilters().put("logout", logoutFilter);
        
        List<Permission> permissions = permissionService.selectAll();
        if (null != permissions) {
            for (Permission permission : permissions) {
                String url = permission.getUrl();
                List<Role> roles = roleService.selectRoleByUrl(url);
                
                String roleStr = "roles[";
                for (int i = 0; i < roles.size(); i++) {
                    if (i == 0) {
                        roleStr += roles.get(i).getName();
                    } else {
                        roleStr += "," + roles.get(i).getName();
                    }
                }
                
                roleStr += "]";
                filterChainDefinitionMap.put(url, roleStr);
            }
        }
        
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
    
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm);
        return securityManager;
    }
}