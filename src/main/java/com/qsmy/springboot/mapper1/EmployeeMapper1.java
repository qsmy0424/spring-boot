package com.qsmy.springboot.mapper1;


import com.qsmy.springboot.bean.Employee;

/**
 * @author qsmy
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper1 {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
