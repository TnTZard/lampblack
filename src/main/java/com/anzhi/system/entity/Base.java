package com.anzhi.system.entity;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class Base {
	
	
	private Integer id;
	
	
	   /**
     * 创建时间
     */
    private LocalDateTime createtime;

    
    /**
     * 修改时间
     */
    private LocalDateTime updatetime;
	
	
}
