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
public class Resources extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源url
     */
        @TableField("resUrl")
    private String resUrl;

    /**
     * 父资源
     */
        @TableField("parentId")
    private Integer parentId;


}
