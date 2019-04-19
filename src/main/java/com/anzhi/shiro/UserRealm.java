package com.anzhi.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anzhi.jwt.JWTToken;
import com.anzhi.jwt.JWTUtil;
import com.anzhi.system.entity.Resources;
import com.anzhi.system.entity.Role;
import com.anzhi.system.entity.User;
import com.anzhi.system.service.IResourcesService;
import com.anzhi.system.service.IRoleService;
import com.anzhi.system.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IResourcesService resourcesService;
	
	public boolean supports(AuthenticationToken token) {
		return token instanceof JWTToken;
	}
	
	/**
	 * 执行授权逻辑   获取用户的角色和权限
	 */
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		System.out.println("执行授权逻辑");	
		String username = JWTUtil.getUsername(token.toString());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		
		Role   role 		= roleService.find(username);
		String roleDesc     = role.getRoleDesc();		
		Set<String> roleSet = new HashSet<>();
		roleSet.add(roleDesc);	
		
		//获取用户权限集
		List<Resources> resourcesList = resourcesService.findUserRes(username);
        Set<String> resources = resourcesList.stream().map(Resources::getResUrl).collect(Collectors.toSet());		
        simpleAuthorizationInfo.setStringPermissions(resources);
		simpleAuthorizationInfo.setRoles(roleSet);		
		return simpleAuthorizationInfo;
	}

	
	/**
	 * 执行认证逻辑
	 */
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		// 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的，已经经过了解密
		
		String token     	= (String)authenticationToken.getCredentials();
		String username   	= JWTUtil.getUsername(token);
		System.out.println("用户名"+username);	
		
		if(username == null) {
			throw new AuthenticationException("token invalid");
		}

		User user       = userService.findByName(username);
		System.out.println(user.toString());
		String password = user.getPassword();
	     // 通过用户名查询用户信息
        if (password == null) {
            throw new AuthenticationException("该用户不存在");
        }
        if (!JWTUtil.verify(token, username, user.getPassword())) {
        	throw new AuthenticationException("token校验不通过");
        }
	
        
        return new SimpleAuthenticationInfo(token, token, "febs_shiro_realm");
	}

	
}
