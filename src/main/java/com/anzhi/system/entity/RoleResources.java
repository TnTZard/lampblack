package com.anzhi.system.entity;

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
public class RoleResources extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleid;

    private Integer resourcesid;


}
