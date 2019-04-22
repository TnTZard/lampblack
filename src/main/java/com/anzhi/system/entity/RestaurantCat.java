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
public class RestaurantCat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜系名称
     */
    private String name;

    /**
     * 简述
     */
    private String remarks;

    /**
     * 状态 0：禁用  1：启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;


}
