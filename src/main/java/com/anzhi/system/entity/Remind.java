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
public class Remind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 餐厅企业
     */
    private Integer restaurantid;

    /**
     * 监控点
     */
    private Integer positionid;

    /**
     * 设备号
     */
    private Integer devicenoid;

    /**
     * 运维提醒描述
     */
    private String remarks;

    /**
     * 提醒状态 0：不提醒  1：提醒
     */
    private Integer remindstatus;


}
