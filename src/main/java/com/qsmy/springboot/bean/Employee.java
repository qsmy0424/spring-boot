package com.qsmy.springboot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qsmy
 */
@Data
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
