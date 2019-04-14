package com.qsmy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    // @ConfigurationProperties(prefix = "spring.datasource")
    // @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    /**
     * 配置Durid监控，配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>(4);
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        // 默认允许所有访问
        initParams.put("allow", "");
        initParams.put("deny", "192.168.56.1");
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        Map<String, String> initParams = new HashMap<>(4);
        bean.setFilter(new WebStatFilter());
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
