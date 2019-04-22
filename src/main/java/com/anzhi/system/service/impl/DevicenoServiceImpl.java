package com.anzhi.system.service.impl;

import com.anzhi.system.entity.Deviceno;
import com.anzhi.system.mapper.DevicenoMapper;
import com.anzhi.system.service.IDevicenoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Andy
 */
@Service
public class DevicenoServiceImpl extends ServiceImpl<DevicenoMapper, Deviceno> implements IDevicenoService {

	@Override
	public Deviceno getDeviceno(String name) {
		return baseMapper.selectOne(new LambdaQueryWrapper<Deviceno>().eq(Deviceno::getDevicenoname,name));
	}
	
	
	
}
