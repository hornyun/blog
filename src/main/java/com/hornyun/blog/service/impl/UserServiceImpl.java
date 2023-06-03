package com.hornyun.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.mapper.UserMapper;
import com.hornyun.blog.service.IUserService;
import com.hornyun.blog.util.PasswordUtil;
import com.hornyun.blog.util.UUIDUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
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
    public User queryByUsername(String username) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getUsername, username);
        return this.getOne(query);
    }
    @Override
    public BlogResponse<User> register(User user) {
        user.setId(UUIDUtils.generate());
        String salt = PasswordUtil.generateSalt();
        String encryptPassword = new SimpleHash("MD5", user.getPassword(), salt,1024).toHex();
        user.setSalt(salt);
        user.setPassword(encryptPassword);
        boolean save = this.save(user);
        if (save) {
            return BlogResponse.success(null);
        }
        return BlogResponse.failure(null);
    }

}
