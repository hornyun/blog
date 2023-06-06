package com.hornyun.blog.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hornyun
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;



    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
}
