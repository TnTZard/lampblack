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
public class Warning implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 报警编号
     */
    private String warningid;

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
     * 菜系
     */
    private Integer restaurantcatid;

    /**
     * 设备号
     */
    private Integer devicenoid;

    /**
     * 监控点
     */
    private Integer positionid;

    /**
     * 地址
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
     * 超标平均浓度
     */
    private Float averageconc;

    /**
     * 最大浓度
     */
    private Float maxconc;

    /**
     * 超标开始时间
     */
    private LocalDateTime starttime;

    /**
     * 最后预警时间
     */
    private LocalDateTime lasttime;

    /**
     * 预警次数
     */
    private Integer warningnum;

    /**
     * 报警拍照
     */
    private String warningphoto;

    /**
     * 一级问题反馈
     */
    private String yipd;

    /**
     * 一级检测图片1
     */
    private String yiphoto1;

    /**
     * 一级检测图片2
     */
    private String yiphoto2;

    /**
     * 一级检测图片3
     */
    private String yiphoto3;

    /**
     * 一级处理状态 0：未处理  1：待处理  2:已处理
     */
    private Integer yistatus;

    /**
     * 二级问题反馈
     */
    private String erpd;

    /**
     * 二级检测图片1
     */
    private String erphoto1;

    /**
     * 二级检测图片2
     */
    private String erphoto2;

    /**
     * 二级检测图片3
     */
    private String erphoto3;

    /**
     * 二级处理状态 0：未处理  1：待处理  2:已处理
     */
    private Integer erstatus;

    /**
     * 三级问题反馈
     */
    private String sanpd;

    /**
     * 三级检测图片1
     */
    private String sanphoto1;

    /**
     * 三级检测图片2
     */
    private String sanphoto2;

    /**
     * 三级检测图片3
     */
    private String sanphoto3;

    /**
     * 三级处理状态 0：未处理  1：待处理  2:已处理
     */
    private Integer sanstatus;


}
