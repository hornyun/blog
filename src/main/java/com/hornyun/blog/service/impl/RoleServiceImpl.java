package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.Role;
import com.hornyun.blog.mapper.RoleMapper;
import com.hornyun.blog.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客系统角色 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
