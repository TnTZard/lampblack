package com.anzhi.system.service.impl;

import com.anzhi.system.entity.User;
import com.anzhi.system.mapper.UserMapper;
import com.anzhi.system.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Andy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public User findByName(String username) {
		return baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));		
	}

	

}
