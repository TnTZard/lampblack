package com.anzhi.work.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("Fume_data")
public class FumeData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 设备号
     */
    private String deviceno;

    /**
     * 数据时间
     */
    private LocalDateTime dateTime;

    /**
     * 浓度
     */
    private Float conc;

    /**
     * 温度
     */
    private Float temp;

    /**
     * 湿度
     */
    private Float hum;

    /**
     * 风速
     */
        @TableField("AI0")
    private Float ai0;

        @TableField("AI1")
    private Float ai1;

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


}
