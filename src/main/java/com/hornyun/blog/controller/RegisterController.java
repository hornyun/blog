package com.hornyun.blog.controller;


import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hornyun
 */
@RestController
public class RegisterController {

    @Resource
    UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public BlogResponse<User> register(User user) {
        return userServiceImpl.register(user);
    }
}
