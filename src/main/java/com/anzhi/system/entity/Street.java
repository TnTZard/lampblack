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
public class Street implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 区域
     */
    private Integer areaid;

    /**
     * 街道名称
     */
    private String name;

    /**
     * 状态 0：禁用  1：启用
     */
    private Integer status;


}
