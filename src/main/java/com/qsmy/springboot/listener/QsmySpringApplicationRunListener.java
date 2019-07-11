package com.qsmy.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author qsmy
 * @desctiption TODO
 * @date 2019-03-27 20:36
 */
public class QsmySpringApplicationRunListener implements SpringApplicationRunListener {
    public QsmySpringApplicationRunListener(SpringApplication application, String[] args) {
    }
    @Override
    public void starting() {
        System.out.println("QsmySpringApplicationRunListener---starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("QsmySpringApplicationRunListener---environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("QsmySpringApplicationRunListener---contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("QsmySpringApplicationRunListener---contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("QsmySpringApplicationRunListener---started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("QsmySpringApplicationRunListener---running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("QsmySpringApplicationRunListener---failed");
    }
}
