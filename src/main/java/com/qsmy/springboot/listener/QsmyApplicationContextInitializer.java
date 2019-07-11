package com.qsmy.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author qsmy
 * @desctiption TODO
 * @date 2019-03-27 20:32
 */
public class QsmyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("QsmyApplicationContextInitializer----------------------------" + applicationContext);
    }
}
