package com.qsmy.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author qsmy
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener 初始化！！！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener 销毁！！！");
    }
}
