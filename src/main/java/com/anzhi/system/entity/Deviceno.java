package com.anzhi.system.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Deviceno implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备名称
     */
    private String devicenoname;

    /**
     * 监控点
     */
    private Integer monitoringpointsid;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 在线状态 0：不在线  1：在线
     */
    private Integer onlinestatus;

    /**
     * 风机状态 0：异常  1：正常
     */
        @TableField("DI0")
    private Integer di0;

    /**
     * 净化器状态 0：异常  1：正常
     */
        @TableField("DI1")
    private Integer di1;

    /**
     * 探头状态 0：异常  1：正常
     */
        @TableField("DI2")
    private Integer di2;

    /**
     * 实时浓度
     */
    private Float realconc;

    /**
     * 实时风速
     */
    private Float windspeed;

    /**
     * 图片
     */
    private String photo;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;


}
