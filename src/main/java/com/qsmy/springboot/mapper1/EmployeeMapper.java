package com.qsmy.springboot.mapper1;

import com.qsmy.springboot.bean.Employee;

/**
 * @author qsmy
 */
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}