package com.hornyun.blog.shiro;

import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hornyun
 */
@Component
@Slf4j
public class BlogRealm extends AuthenticatingRealm {

    @Resource
    private IUserService userServiceImpl;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (StringUtils.isEmpty(token.getUsername()) || ArrayUtils.isEmpty(token.getPassword())) {
            throw new UnknownAccountException("请正确输入登录信息");
        }
        String username = token.getUsername();
        User login = userServiceImpl.queryByUsername(username);
        if (login == null) {
            throw new UnknownAccountException("用户名或密码错误");
        } else {
            ByteSource credentialsSalt = ByteSource.Util.bytes(login.getSalt());
            return new SimpleAuthenticationInfo(login, login.getPassword(), credentialsSalt, getName());
        }

    }
}
