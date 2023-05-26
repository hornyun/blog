package com.hornyun.blog.config;

import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hornyun
 */
@Component
public class BlogRealm extends AuthenticatingRealm {
    @Resource
    private IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User login = userService.login(username);
        if (login == null) {
            return null;
        }else{
            return new SimpleAuthenticationInfo(login, login.getPassword(), "");
        }
    }

}
