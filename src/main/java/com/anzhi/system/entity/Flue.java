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
public class Flue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 监控点
     */
    private Integer positionid;

    /**
     * 编号
     */
    private String numbering;

    /**
     * 烟道名称
     */
    private String name;

    /**
     * 烟道描述
     */
    private String remarks;

    /**
     * 状态 0：异常  1：正常
     */
    private Integer status;

    /**
     * 烟道面积
     */
    private Float fluearea;


}
