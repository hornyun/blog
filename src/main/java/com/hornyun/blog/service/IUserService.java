package com.hornyun.blog.service;

import com.hornyun.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 博客系统用户表 服务类
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
public interface IUserService extends IService<User> {
    /**
     * login method
     * @param username user name
     * @return user
     */
    User login(String username);
}
