package com.qsmy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author qsmy
 * @desctiption TODO
 * @Date 2019-04-11 18:52
 */
@Configuration
@MapperScan(basePackages = "com.qsmy.springboot.mapper2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSource2Config {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.qsmy2")
    public DruidDataSource test2DataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager test2TransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
