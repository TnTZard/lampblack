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
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地区编码
     */
    private String adcode;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态 0：禁用  1：启用
     */
    private Integer status;


}
