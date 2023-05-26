package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.UserRole;
import com.hornyun.blog.mapper.UserRoleMapper;
import com.hornyun.blog.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-25
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
