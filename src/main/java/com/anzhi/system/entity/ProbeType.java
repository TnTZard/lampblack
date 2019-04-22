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
public class ProbeType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 探头类型
     */
    private String name;

    /**
     * 探头类型描述
     */
    private String remarks;

    /**
     * 状态 0：不启用  1：启用
     */
    private Integer status;


}
