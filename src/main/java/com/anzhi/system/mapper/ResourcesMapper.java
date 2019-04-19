package com.anzhi.system.mapper;

import java.util.List;

import com.anzhi.system.entity.Resources;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;



/**
 * @author Andy
 */
public interface ResourcesMapper extends BaseMapper<Resources> {
	 
	
	List<Resources> findUserRes(String userName);
	 
	 
	 
	 
}
