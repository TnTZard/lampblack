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
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 事件编号
     */
    private String eventid;

    /**
     * 事件名称
     */
    private String name;

    /**
     * 事件类型 0：设备安装  1：备案情况  2:烟道情况  3；新店开业
     */
    private String eventtype;

    /**
     * 餐厅企业
     */
    private String restaurant;

    /**
     * 发送人
     */
    private Integer sendid;

    /**
     * 事件详情
     */
    private String eventdetails;

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
     * 状态 0：已发送  1：已查阅
     */
    private Integer status;

    /**
     * 街道
     */
    private Integer streetid;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;


}
