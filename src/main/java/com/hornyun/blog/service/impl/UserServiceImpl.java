package com.hornyun.blog.service.impl;

import com.hornyun.blog.entity.User;
import com.hornyun.blog.mapper.UserMapper;
import com.hornyun.blog.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hornyun
 * @since 2023-05-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
