package com.anzhi.system.controller;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.anzhi.common.domain.AzException;
import com.anzhi.common.domain.AzResponse;
import com.anzhi.common.properties.FebsProperties;
import com.anzhi.common.utils.DateUtil;
import com.anzhi.common.utils.FebsUtil;
import com.anzhi.jwt.JWTToken;
import com.anzhi.jwt.JWTUtil;
import com.anzhi.system.entity.Resources;
import com.anzhi.system.entity.Role;
import com.anzhi.system.entity.User;
import com.anzhi.system.service.IResourcesService;
import com.anzhi.system.service.IRoleService;
import com.anzhi.system.service.IUserService;





@RestController
@RequestMapping(value = { "/v1" }, produces = "application/json;charset=UTF-8")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IResourcesService resourcesService;
	
	@Autowired
    private FebsProperties properties;

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping("/login")
	public AzResponse login(HttpServletRequest request,@RequestBody Map<String, Object> requestBody) throws Exception{
		
		String username = (String)requestBody.get("username");
		String password = (String)requestBody.get("password");
		User	   user = userService.findByName(username);
		
		final String errorMessage = "用户名或密码错误";
		
		if (user == null) {
			return new AzResponse().fail().message("该用户不存在！");
		}
        if (!StringUtils.equals(user.getPassword(), password)){
            return new AzResponse().fail().message("密码错误！");
        }
        if (User.STATUS_LOCK.equals(user.getEnable())){
        	return new AzResponse().fail().message("账号已被锁定,请联系管理员！");
            
        }
		
		System.out.println("LoginController()"+username);
		System.out.println(JWTUtil.sign(username, password));	
		String token = FebsUtil.encryptToken(JWTUtil.sign(username, password));
		System.out.println("加密后的token" + token);
		LocalDateTime expireTime = LocalDateTime.now().plusSeconds(properties.getShiro().getJwtTimeOut());
	    String expireTimeStr = DateUtil.formatFullTime(expireTime);	        
	    JWTToken jwtToken = new JWTToken(token, expireTimeStr);       
		Map<String, Object> userInfo = this.generateUserInfo(jwtToken, user);
		
		return new AzResponse().message("登录成功").data(userInfo);
	}
	
	
	@GetMapping("/user")
	@RequiresPermissions("user:add")
	public AzResponse test() {
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnn");
		return new AzResponse().success().data("222");
	}
	
	
	@RequestMapping("/logout")
	public AzResponse logOut(HttpServletRequest request,String username) {
		User user = userService.findByName(username);
		
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.logout();
		} catch (Exception e) {
			return new AzResponse().fail().message("错误！");
		}
		
		return new AzResponse().success().message("您已登出！");
	}
	
	   /**
     * 生成前端需要的用户信息，包括：
     * 1. token
     * 2. Vue Router
     * 3. 用户角色
     * 4. 用户权限
     * 5. 前端系统个性化配置信息
     *
     * @param token token
     * @param user  用户信息
     * @return UserInfo
     */
    private Map<String, Object> generateUserInfo(JWTToken token, User user) {
        String username = user.getUsername();
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("token", token.getToken());
        userInfo.put("exipreTime", token.getExpireAt());

        
        Role role 		= roleService.find(username);
		String roleDesc = role.getRoleDesc();	
		Set<String> roleSet = new HashSet<>();
		roleSet.add(roleDesc);       
        userInfo.put("roles", roleSet);
//
    	
        
        List<Resources> resourcesList = resourcesService.findUserRes(username);
        Set<String> resources = resourcesList.stream().map(Resources::getResUrl).collect(Collectors.toSet());
        
        userInfo.put("resources", resources);
//       
        user.setPassword("it's a secret");
        userInfo.put("user", user);
        return userInfo;
        
    }
    
    
    
    
}
