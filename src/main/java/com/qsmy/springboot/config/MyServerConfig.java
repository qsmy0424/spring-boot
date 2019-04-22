package com.qsmy.springboot.config;

import com.qsmy.springboot.listener.MyListener;
import com.qsmy.springboot.filter.MyFilter;
import com.qsmy.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.addUrlMappings("/myServlet");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/qsmy", "/myServlet"));
        // order数字越小，优先级越高
        filterRegistrationBean.setOrder(6);
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean<MyListener> listenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setListener(new MyListener());
        return listenerRegistrationBean;
    }
}
