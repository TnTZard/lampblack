package com.anzhi.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anzhi.jwt.JWTFilter;



/**
 * 
 * @author Andy
 *
 *	shiro的配置类
 *
 */


@Configuration
public class ShiroConfig {
		
	/**
	 * 
	 * 创建shirofilterFactoryBean
	 * 
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
		filterMap.put("jwt",new JWTFilter());
		shiroFilterFactoryBean.setFilters(filterMap);
		
		
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
	    // 所有请求都要经过 jwt过滤器
	    filterChainDefinitionMap.put("/**", "jwt");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		
		return shiroFilterFactoryBean;
		
	}
	
		
	/**
	 * 
	 * 创建DefaultWebSecurityManager
	 * 
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();	
		securityManager.setRealm(userRealm);
		return securityManager;		
	}
	
	
		
	/**
	 * 
	 * 创建Realm
	 * 
	 */
	
	@Bean(name = "userRealm")
	public UserRealm getRealm(){
		return new UserRealm();
	}
	
	@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
	
	
	//没有它居然进不去授权逻辑。。。。
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator app=new DefaultAdvisorAutoProxyCreator();
		app.setProxyTargetClass(true);
		return app;
	}	
	
	
}
