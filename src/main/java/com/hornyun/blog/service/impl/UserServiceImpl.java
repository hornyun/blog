package com.hornyun.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.mapper.UserMapper;
import com.hornyun.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客系统用户表 服务实现类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User login(String username) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getUsername, username);
        return this.getOne(query);
    }
}
