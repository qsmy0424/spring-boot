package com.qsmy.springboot;

import com.qsmy.springboot.bean.People;
import com.qsmy.springboot.mapper1.DepartmentMapper1;
import com.qsmy.springboot.mapper1.EmployeeMapper1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private People people;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    EmployeeMapper1 employeeMapper1;
    @Autowired
    DepartmentMapper1 departmentMapper1;
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() {
        System.out.println(people);
        System.out.println(people.getList().size());
        System.out.println(people.getMaps().size());
    }

    @Test
    public void test() {
        String[] strings = StringUtils.commaDelimitedListToStringArray(StringUtils.trimAllWhitespace("qsmy.wwhm"));
        System.out.println(strings.length);
        for (String string : strings) {
            System.out.println("result    "+ string);
        }
    }

    @Test
    public void test1() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from qsmy");
        System.out.println(list.get(0));
        System.out.println(dataSource);
        System.out.println(dataSource.getClass());
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        System.out.println(departmentMapper1);
    }


}

