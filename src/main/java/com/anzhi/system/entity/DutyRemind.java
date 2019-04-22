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
public class DutyRemind implements Serializable {

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
     * 上次维护时间
     */
    private LocalDateTime createtime;

    /**
     * 下次需维护时间
     */
    private LocalDateTime waitingtime;


}
