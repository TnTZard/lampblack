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
public class DutyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 运维编号
     */
    private String dutyid;

    /**
     * 餐厅企业
     */
    private Integer restaurantid;

    /**
     * 区域
     */
    private Integer areaid;

    /**
     * 街道
     */
    private Integer streetid;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 企业负责人
     */
    private String restaurantperson;

    /**
     * 企业负责人电话
     */
    private String restaurantphone;

    /**
     * 网格员
     */
    private Integer gridid;

    /**
     * 网格员电话
     */
    private String gridphone;

    /**
     * 运维人员
     */
    private Integer operationid;

    /**
     * 运维人员电话
     */
    private String operationphone;

    /**
     * 设备号
     */
    private Integer devicenoid;

    /**
     * 监控点
     */
    private Integer positionid;

    /**
     * 事件类型 0：烟道清理  1：探头清理  2:仪器检查  3；全面维护  4:故障维修
     */
    private String dutytype;

    /**
     * 运维描述
     */
    private String dutyremarks;

    /**
     * 图片1
     */
    private String photo1;

    /**
     * 图片2
     */
    private String photo2;

    /**
     * 图片3
     */
    private String photo3;

    /**
     * 执行开始时间
     */
    private LocalDateTime createtime;

    /**
     * 执行结束时间
     */
    private LocalDateTime updatetime;


}
