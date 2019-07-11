package com.qsmy.springboot.mapper2;


import com.qsmy.springboot.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author qsmy
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper2 {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
