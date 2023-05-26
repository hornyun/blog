package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.Menu;
import com.hornyun.blog.mapper.MenuMapper;
import com.hornyun.blog.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客系统菜单管理 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
