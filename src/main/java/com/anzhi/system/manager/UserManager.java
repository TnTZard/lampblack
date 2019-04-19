package com.anzhi.system.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzhi.common.utils.FebsUtil;
import com.anzhi.system.entity.User;
import com.anzhi.system.service.IRoleService;
import com.anzhi.system.service.IUserService;



/**
 * 封装一些和 User相关的业务操作
 */

@Service
public class UserManager {



    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;

    


//    /**
//     * 通过用户名获取用户基本信息
//     *
//     * @param username 用户名
//     * @return 用户基本信息
//     */
//    public User getUser(String username) {
//        return FebsUtil.selectCacheByTemplate(
//                () -> this.cacheService.getUser(username),
//                () -> this.userService.findByName(username));
//    }

 
	
	
	
	
	
	
	
	
	
	
	
}
