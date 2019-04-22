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
public class Probe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备名称
     */
    private Integer devicenoid;

    /**
     * 探头类型
     */
    private Integer probtypeid;

    /**
     * 编号
     */
    private String numbering;

    /**
     * 探头名称
     */
    private String name;

    /**
     * 探头描述
     */
    private String remarks;

    /**
     * 状态 0：异常  1：正常
     */
    private Integer status;


}
