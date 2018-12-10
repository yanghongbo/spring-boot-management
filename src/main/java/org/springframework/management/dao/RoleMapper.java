package org.springframework.management.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.management.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author allen
 * @since 2018-12-05
 */
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from ")
    List<Role> selectRoleByUid(@Param("uid") Integer uid);

}
