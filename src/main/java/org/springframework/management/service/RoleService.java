package org.springframework.management.service;

import org.springframework.management.entity.Role;
import org.springframework.management.dao.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author allen
 * @since 2018-12-05
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

}
