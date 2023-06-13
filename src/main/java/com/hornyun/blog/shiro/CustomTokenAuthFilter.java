package com.hornyun.blog.shiro;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hornyun.blog.dto.BlogResponse;
import com.hornyun.blog.entity.User;
import com.hornyun.blog.exception.BlogBaseException;
import com.hornyun.blog.service.impl.TokenService;
import com.hornyun.blog.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hornyun
 */
@Slf4j
public class CustomTokenAuthFilter extends FormAuthenticationFilter {
    private static final String TOKEN_NAME = "blog_token";

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String token = getToken(httpServletRequest);
        log.info("http request session Id is {}", ((HttpServletRequest) request).getSession().getId());
        if (StringUtils.isNoneBlank(token)) {
            return new BlogToken(token);
        } else {
            return super.createToken(request, response);
        }
    }


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //todo which can set redis-key by sessionId
        log.info("http request session Id is {}", ((HttpServletRequest) request).getSession().getId());
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }else{
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String token = getToken(httpRequest);
            if (!StringUtils.isEmpty(token)) {
                TokenService tokenService = SpringContextUtil.getBean("tokenService");
                tokenService.refreshToken(token);
                User user = tokenService.getUserByToken(token);
                return user != null;
            }
            return false;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }
                return executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }
                //allow them to see the login page ;)
                return true;
            }
        } else {
            if (log.isTraceEnabled()) {
                log.trace("Attempting to access a path which requires authentication.  Forwarding to the " +
                        "Authentication url [" + getLoginUrl() + "]");
            }

            loginFail((HttpServletRequest) request, (HttpServletResponse) response);
            return false;
        }
    }

    private void loginFail(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        BlogResponse<String> data = BlogResponse.failure("身份校验失败");

        try {
            response.getWriter().print(new ObjectMapper().writeValueAsString(data));
            response.getWriter().close();
        } catch (IOException e) {
            throw new BlogBaseException(e);
        }
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        loginFail((HttpServletRequest) request, (HttpServletResponse) response);
        return false;
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {
            return request.getParameter(TOKEN_NAME);
        }
        return token;
    }
}
