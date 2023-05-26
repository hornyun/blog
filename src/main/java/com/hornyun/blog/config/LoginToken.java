package com.hornyun.blog.config;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * 登陆令牌
 * @author chenyinghui
 *
 */
public class LoginToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 559224938954418724L;
	public LoginToken(String userName, String password, boolean rememberMe,
                      String host) {
		super(userName, password, rememberMe, host);
	}

}
