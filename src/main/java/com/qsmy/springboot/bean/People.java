package com.qsmy.springboot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qsmy
 */
@Data
@Component
@PropertySource(value = {"classpath:people.properties"})
@ConfigurationProperties(prefix = "people")
public class People {
    private String name;
    private Integer age;
    private List<String> list;
    private Date date;
    private Boolean status;
    private Map<String, Object> maps;
    private Dog dog;
}
