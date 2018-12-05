package org.springframework.management.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.management.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author allen
 * @since 2018-12-05
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT count(1) FROM user WHERE name=#{name}")
    int selectCountByName(@Param("name") String name);

    @Select("SELECT count(1) FROM user WHERE name=#{name} AND password=#{password}")
    int selectCountByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Select("SELECT * FROM user WHERE name=#{name} AND password=#{password} limit 1")
    User selectUserByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
