package com.qsmy.springboot.mapper1;

import com.qsmy.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

public interface DepartmentMapper1 {

    @Select("select * from department where id = #{id}")
    @Results({
            @Result(property = "departmentName", column = "departmentNames")
    })
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department (departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int update(Department department);
}
