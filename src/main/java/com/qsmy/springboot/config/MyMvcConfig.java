package com.qsmy.springboot.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qsmy
 * 使用WebMvcConfigurer接口来扩展SpringMVC的功能
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/qsmy1").setViewName("success");
        registry.addViewController("interceptor").setViewName("interceptor");
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        // SpringBoot已经做好的静态资源映射
        // registry.addInterceptor(new MyHandlerInterceptor())
        //         .addPathPatterns("/**")
        //         .excludePathPatterns("/qsmy1", "qsmy");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        WebServerFactoryCustomizer<ConfigurableWebServerFactory> customizer = factory -> factory.setPort(9000);
        return customizer;
    }
}
