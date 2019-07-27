package com.qsmy.springboot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author qsmy
 * @date 2019-07-24
 */
@Slf4j
@WebListener
public class AnnotationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("AnnotationListener --- contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("AnnotationListener --- contextDestroyed");
    }
}
