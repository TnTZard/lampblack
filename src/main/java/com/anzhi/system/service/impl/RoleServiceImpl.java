package com.anzhi.system.service.impl;

import com.anzhi.system.entity.Role;
import com.anzhi.system.mapper.RoleMapper;
import com.anzhi.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Andy
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
	@Override
	public Role find(String username) {
		return baseMapper.find(username);
	}

}
