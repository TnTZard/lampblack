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
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
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
     * 资源类型   1:菜单    2：按钮
     */
    private Integer type;

    /**
     * 父资源
     */
        @TableField("parentId")
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;


}
