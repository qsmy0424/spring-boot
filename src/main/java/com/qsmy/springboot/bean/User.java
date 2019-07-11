package com.qsmy.springboot.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author qsmy
 * @date 2019-03-26 17:05
 */
@Data
// 使用JPA注解配置映射关系
@Entity     // 告诉JPA这是一个实体类（和数据表映射的类）
@Table   // @Table来指定和哪个数据表对应，如果省略默认表名就是user；
// @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class User {

    @Id     // 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 自增主键
    /**
     * strategy：表示主键生成策略，generator表示主键生成器的名称。
     */
    private Long id;

    @Column(name = "username", length = 50, nullable = true)    // 这是和数据表对应的一个列
    private String username;

    private String password;

    private String roleName;

    private boolean locked;

    // 表示该属性并非一个到数据库表的字段的映射，ORM框架将忽略改属性。
    // @Transient
    // private String test;

    public User(Long id, String username, String password, String roleName, boolean locked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.locked = locked;
    }
}
