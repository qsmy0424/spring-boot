package com.qsmy.springboot.controller;

import com.qsmy.springboot.bean.Department;
import com.qsmy.springboot.bean.Employee;
import com.qsmy.springboot.mapper1.DepartmentMapper1;
import com.qsmy.springboot.mapper1.EmployeeMapper1;
import com.qsmy.springboot.mapper2.DepartmentMapper2;
import com.qsmy.springboot.mapper2.EmployeeMapper2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qsmy
 */
@RestController
public class DeptController {

    private DepartmentMapper1 departmentMapper1;
    private DepartmentMapper2 departmentMapper2;
    private EmployeeMapper1 employeeMapper1;
    private EmployeeMapper2 employeeMapper2;

    @Autowired
    public void setEmployeeMapper2(EmployeeMapper2 employeeMapper2) {
        this.employeeMapper2 = employeeMapper2;
    }

    @Autowired
    public void setDepartmentMapper1(DepartmentMapper1 departmentMapper1) {
        this.departmentMapper1 = departmentMapper1;
    }

    @Autowired
    public void setDepartmentMapper2(DepartmentMapper2 departmentMapper2) {
        this.departmentMapper2 = departmentMapper2;
    }

    @Autowired
    public void setEmployeeMapper1(EmployeeMapper1 employeeMapper1) {
        this.employeeMapper1 = employeeMapper1;
    }

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper1.getDeptById(id);
    }

    @GetMapping("/dept2/{id}")
    public Department getDepartment2(@PathVariable("id") Integer id) {
        return departmentMapper2.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper1.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper1.getEmpById(id);
    }

    @GetMapping("/emp2/{id}")
    public Employee getEmp2(@PathVariable("id") Integer id) {
        return employeeMapper2.getEmpById(id);
    }
}
