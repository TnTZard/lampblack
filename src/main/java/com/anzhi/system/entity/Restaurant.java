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
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 餐厅名称
     */
    private String name;

    /**
     * 组织结构代码
     */
    private String identity;

    /**
     * 简述
     */
    private String remarks;

    /**
     * 营业执照
     */
    private String license;

    /**
     * 菜系
     */
    private Integer restaurantcatid;

    /**
     * 地图
     */
    private String map;

    /**
     * 负责人
     */
    private String person;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态 0：禁用  1：启用
     */
    private Integer isactive;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;


}
