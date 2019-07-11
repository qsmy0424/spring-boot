package com.qsmy.springboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qsmy
 * MyBatis配置属性
 */
@Configuration
public class MyBatisConfig {

    /**
     * 开启驼峰命名规则
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        System.out.println("测试-----");
        return (configuration) -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
