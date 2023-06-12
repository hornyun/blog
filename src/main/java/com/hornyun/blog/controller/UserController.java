package com.hornyun.blog.controller;

import com.hornyun.blog.dto.UserDTO;
import com.hornyun.blog.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

}
