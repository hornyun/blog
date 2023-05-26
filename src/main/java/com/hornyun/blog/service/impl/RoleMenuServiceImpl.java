package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.RoleMenu;
import com.hornyun.blog.mapper.RoleMenuMapper;
import com.hornyun.blog.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-25
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
