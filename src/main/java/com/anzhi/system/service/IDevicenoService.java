package com.anzhi.system.service;

import com.anzhi.system.entity.Deviceno;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Andy
 */
public interface IDevicenoService extends IService<Deviceno> {
	
	Deviceno getDeviceno(String name);
	
}
