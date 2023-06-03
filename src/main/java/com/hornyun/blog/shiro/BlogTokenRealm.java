package com.hornyun.blog.shiro;

import com.hornyun.blog.entity.User;
import com.hornyun.blog.service.impl.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hornyun
 */
@Component
@Slf4j
public class BlogTokenRealm extends AuthenticatingRealm {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof BlogToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        BlogToken token = (BlogToken) authenticationToken;
        User user =  tokenService.getUserByToken(token.getToken());
        if (user == null) {
            throw new UnsupportedTokenException("token is expired.please login again");
        }
        return new SimpleAuthenticationInfo(user, token.getToken(), getName());
    }


}
