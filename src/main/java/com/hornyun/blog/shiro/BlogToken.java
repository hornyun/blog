package com.hornyun.blog.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author hornyun
 */

@Data
public class BlogToken implements AuthenticationToken {
    String token;

    public BlogToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

}
