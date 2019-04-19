package com.anzhi.system.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author Andy
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {
	
	public static final Integer STATUS_LOCK = 0;
	
	
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    /**
     * 是否启用
     */
    private Integer enable;

    /**
     * 角色id
     */
    private Long role;


}
