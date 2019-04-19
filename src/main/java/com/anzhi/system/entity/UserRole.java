package com.anzhi.system.entity;

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
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("userId")
    private Integer userId;

    @TableField("roleId")
    private Integer roleId;


}
