package org.springframework.management.service.impl;

import org.springframework.management.entity.User;
import org.springframework.management.mapper.UserMapper;
import org.springframework.management.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author allen
 * @since 2018-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
