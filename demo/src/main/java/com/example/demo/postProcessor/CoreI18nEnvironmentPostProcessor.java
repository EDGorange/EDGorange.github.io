package com.example.demo.postProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-03-17 15:52
 **/

public class CoreI18nEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("i am postProcessEnvironment");
        System.out.println(environment.getSystemEnvironment());
        System.out.println(application.getApplicationStartup());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
