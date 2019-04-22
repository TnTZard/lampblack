package com.anzhi.system.service.impl;

import com.anzhi.system.entity.Resources;
import com.anzhi.system.mapper.ResourcesMapper;
import com.anzhi.system.service.IResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Andy
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {

	@Override
	public List<Resources> findResources(String username) {
		return baseMapper.findResources(username);
	}

}
