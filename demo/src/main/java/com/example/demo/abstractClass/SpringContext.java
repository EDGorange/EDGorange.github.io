package com.example.demo.abstractClass;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-03-15 15:57
 **/
@Component
public  class SpringContext {
    private static ApplicationContext applicationContext;

    public SpringContext() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringContext.applicationContext == null) {
            SpringContext.applicationContext = applicationContext;
        }

    }

    public static <T> T getBean(Class<T> beanClass) {
        return getApplicationContext().getBean(beanClass);
    }

    public static Object getBean(String name, boolean ignoreNotFound) {
        return !getApplicationContext().containsBean(name) && ignoreNotFound ? null : getBean(name);
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getApplicationContext().getBeansOfType(type);
    }

    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getApplicationContext().getBean(name, requiredType);
    }

    public static Resource getResource(String location) {
        return getApplicationContext().getResource(location);
    }
}

