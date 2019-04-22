package com.anzhi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anzhi.common.domain.AzResponse;
import com.anzhi.system.entity.Deviceno;
import com.anzhi.system.service.IDevicenoService;

/**
 * 首页Index  总览
 * @author admin
 *
 */




@RestController
@RequestMapping(value = "/Index")
public class IndexController {
	
	
	@Autowired
	private IDevicenoService devicenoService;
	
	
	@GetMapping
	public AzResponse getIndex(HttpServletRequest request) {
		
		String name = (String)request.getParameter("devicename");
		
		Deviceno deviceno = devicenoService.getDeviceno(name);
		
		
		
		return new AzResponse().success().message(deviceno.getDevicenoname());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
