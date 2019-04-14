package com.qsmy.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qsmy
 */
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(final List<String> list) {
        this.list = list;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(final Boolean status) {
        this.status = status;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(final Map<String, Object> maps) {
        this.maps = maps;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(final Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                ", date=" + date +
                ", status=" + status +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
