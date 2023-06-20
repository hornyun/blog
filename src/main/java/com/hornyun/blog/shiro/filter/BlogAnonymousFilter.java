package com.hornyun.blog.shiro.filter;

import com.hornyun.blog.util.CorsUtils;
import org.apache.shiro.web.filter.authc.AnonymousFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决跨域请求cookie未正确解析的问题
 *
 * @author hornyun
 */
public class BlogAnonymousFilter extends AnonymousFilter {
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) {
        CorsUtils.setCorsResponse((HttpServletRequest) request, (HttpServletResponse) response);
        return true;
    }

}
