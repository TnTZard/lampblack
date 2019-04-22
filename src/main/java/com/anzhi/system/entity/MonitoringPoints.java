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
public class MonitoringPoints implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 监控点名称
     */
    private String name;

    /**
     * 餐厅
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
     * 备注
     */
    private String remarks;

    /**
     * 图片
     */
    private String photo;

    /**
     * 地址
     */
    private String address;

    /**
     * 地图
     */
    private String map;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 状态 0：禁用  1：启用
     */
    private Integer isactive;

    /**
     * 店铺规模
     */
    private String storesize;

    /**
     * 灶头数
     */
    private Integer stovenum;

    /**
     * 风机数
     */
    private Integer fannum;

    /**
     * 净化器数
     */
    private Integer filternum;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;


}
