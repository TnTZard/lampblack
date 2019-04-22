package com.anzhi.system.service;

import com.anzhi.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Andy
 */
public interface IRoleService extends IService<Role> {
	
	Role getRole(String username);
	
}
