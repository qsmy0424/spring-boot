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
        ServletRegistrationBean<MyServlet> servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/qsmy", "/myServlet"));
        // order数字越小，优先级越高
        filterRegistrationBean.setOrder(6);
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegistrationBean() {
        ServletListenerRegistrationBean listenerRegistrationBean = new ServletListenerRegistrationBean();
        listenerRegistrationBean.setListener(new MyListener());
        return listenerRegistrationBean;
    }
}
