package com.hand.test_26850.mapper;

import com.hand.test_26850.pojo.Employee;
import com.hand.test_26850.vo.EmpVo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    @Select("select * from employee_info where EMP_CODE='#{emp_code}' or EMP_NAME like CONCAT('%',#{emp_name},'%') or (CREATION_DATE between #{startTime} and #{endTime}) limit #{page},#{limit}")
    List<Employee> findEmpsByConditions(EmpVo empVo);
}
