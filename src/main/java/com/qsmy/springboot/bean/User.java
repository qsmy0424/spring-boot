package com.qsmy.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author qsmy
 * @desctiption TODO
 * @Date 2019-03-26 17:05
 */
// 使用JPA注解配置映射关系
@Entity     // 告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tbl_user")   // @Table来指定和哪个数据表对应，如果省略默认表名就是user；
// @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class User {

    @Id     // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 自增主键
    /**
     * strategy：表示主键生成策略，generator表示主键生成器的名称。
     */
    private Integer id;

    @Column(name = "last_name", length = 50, nullable = true)    // 这是和数据表对应的一个列
    private String lastName;

    @Column     // 省略默认列名就是属性名
    private String email;

    @Transient  // 表示该属性并非一个到数据库表的字段的映射，ORM框架将忽略改属性。
    private String test;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
