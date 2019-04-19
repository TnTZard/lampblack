package com.anzhi.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.anzhi.system.service.IUserService;



/**
 * @author Andy
 */
@RestController
@RequestMapping("/system/user")
public class UserController {
	
	private IUserService userService;
	
	

}
