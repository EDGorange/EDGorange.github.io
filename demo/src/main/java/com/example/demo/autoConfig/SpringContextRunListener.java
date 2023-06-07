package com.example.demo.autoConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @description: br
 * @author: wang.chengcheng
 * @create: 2023-03-17 15:40
 **/


public class SpringContextRunListener implements SpringApplicationRunListener {
    public static final String BOOTSTRAP_PROPERTY_SOURCE_NAME = "bootstrap";
    private ObjectMapper mapper = new ObjectMapper();
    private static final String HEALTH_CHECK_FILE_PATTERN = "%s/checkpreload/healthcheck.log";
    private static final String HEALTH_CHECK_CODE = "UP";

    public SpringContextRunListener(SpringApplication application, String[] args) {
    }

    public void starting() {
        System.out.println("The application is starting.");
    }

    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.setProperty("spring.main.allow-bean-definition-overriding", "true");
        System.out.println("The application environment [{}] has been prepared." + new Object[]{environment.getClass()});
    }

    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("The application context [id = {}, name = {}] has been prepared." +  new Object[]{context.getId(), context.getDisplayName()});
        ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("i am context prepared....");


/*        ThirdPartyLogMaskJudge.setLogMaskOn(LogMaskCtrl.isLogMask());
        ThirdPartyLogMaskJudge.setThirdPartyPkg(LogMaskCtrl.thirdPartyPkg());*/
    }

    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("The application context [id = {}, name = {}] has been loaded." + new Object[]{context.getId(), context.getDisplayName()});
    }

    public void started(ConfigurableApplicationContext context) {
        System.out.println("i am started ...");
    }

    public void running(ConfigurableApplicationContext context) {
        //this.logConfigInfo(context);
        ConfigurableEnvironment environment = context.getEnvironment();
        if (!environment.getPropertySources().contains("bootstrap")) {
            System.out.println("i am running");
        }

    }

    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("i am failed...");

    }


}


