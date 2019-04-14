package com.qsmy.springboot.controller;

import com.qsmy.springboot.bean.Department;
import com.qsmy.springboot.bean.Employee;
import com.qsmy.springboot.mapper1.DepartmentMapper1;
import com.qsmy.springboot.mapper1.EmployeeMapper1;
import com.qsmy.springboot.mapper2.DepartmentMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    private DepartmentMapper1 departmentMapper1;
    @Autowired
    private DepartmentMapper2 departmentMapper2;
    @Autowired
    private EmployeeMapper1 employeeMapper1;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        Department department = departmentMapper1.getDeptById(id);
        return department;
    }
    @GetMapping("/dept2/{id}")
    public Department getDepartment2(@PathVariable("id") Integer id) {
        Department department = departmentMapper2.getDeptById(id);
        return department;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper1.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeMapper1.getEmpById(id);
        return emp;
    }
}
