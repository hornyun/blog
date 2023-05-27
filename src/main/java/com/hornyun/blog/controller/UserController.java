package com.hornyun.blog.controller;

import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 * 博客系统用户表 前端控制器
 * </p>
 *
 * @author HornYun
 * @since 2023-05-24
 */
@Controller
public class UserController {
    @Resource(name="userServiceImpl")
    private IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public BlogResponse<User> login(User user) {
        User login = userService.login(user.getUsername());
        return BlogResponse.success(login);
    }

}
