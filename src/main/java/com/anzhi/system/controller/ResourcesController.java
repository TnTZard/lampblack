package com.anzhi.system.controller;


import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.anzhi.common.domain.AzResponse;


/**
 * @author Andy
 */
@RestController
@RequestMapping("/system/resources")
public class ResourcesController {
	
	
	@GetMapping("/get")
	@RequiresRoles("admin")
	public AzResponse getResource() {
		return new AzResponse().success().message("管理员访问");
	}

	
	
	@GetMapping("/get2")
	@RequiresRoles("vip")	
	public AzResponse getResource2() {
		return new AzResponse().success().message("vip访问");
	}
	
	@GetMapping("/get3")
	@RequiresRoles("net")
	@RequiresPermissions("/roles/add")
	public AzResponse getResource3() {
		return new AzResponse().success().message("net访问");
	}
	
	
	
	
	
}
