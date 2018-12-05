package org.springframework.management.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author allen
 * @since 2018-12-05
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色
     */
    private String role;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String describe;


}
