package com.anzhi.system.mapper;

import com.anzhi.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Andy
 */
public interface RoleMapper extends BaseMapper<Role> {
	
	Role find(String username);

}
