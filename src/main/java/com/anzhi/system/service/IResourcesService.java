package com.anzhi.system.service;

import java.util.List;

import com.anzhi.system.entity.Resources;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Andy
 */
public interface IResourcesService extends IService<Resources> {
	
	List<Resources> findUserRes(String userName);
	
	
}
