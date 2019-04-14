package com.qsmy.springboot.mapper2;


import com.qsmy.springboot.bean.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper2 {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
