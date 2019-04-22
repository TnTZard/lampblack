package com.anzhi.system.entity;


import java.io.Serializable;
import java.util.List;
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
public class Role extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称:管理员 超级管理员 运维人员 监管人员 网格员 企业 执法员
     */
    private String name;

    
    /**
     *   角色对应的资源集合
     */
    private List<Resources> resList;
    
    
    
}
