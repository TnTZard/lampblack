package com.anzhi.system.entity;

import java.time.LocalDateTime;
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
public class User extends Base implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static final Integer STATUS_LOCK = 0;

    /**
     * 用户名
     */
    private String loginname;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String photo;

    /**
     * 是否启用 0：未启用  1：启用
     */
    private Integer enable;

    /**
     * 电话
     */
    private String phone;

    /**
     * 所属街道
     */
    private Integer streetid;

    /**
     * 角色
     */
    private Integer roleid;

    /**
     * 所属餐厅企业
     */
    private Integer restaurantid;

 


}
