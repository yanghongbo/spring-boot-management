package org.springframework.management.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.management.entity.User;
import org.springframework.management.dao.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author allen
 * @since 2018-12-05
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public Boolean isNameExist(String name) {
        int count = baseMapper.selectCountByName(name);
        return (count > 0) ? true : false;
    }

    public Boolean isNameAndPasswordExist(String name, String password) {
        int count = baseMapper.selectCountByNameAndPassword(name, password);
        return (count > 0) ? true : false;
    }

    public User findByNameAndPassword(String name, String password) {
        return baseMapper.selectUserByNameAndPassword(name, password);
    }
}
