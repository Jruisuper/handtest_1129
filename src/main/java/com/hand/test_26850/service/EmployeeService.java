package com.hand.test_26850.service;

import com.hand.test_26850.mapper.EmployeeMapper;
import com.hand.test_26850.pojo.Employee;
import com.hand.test_26850.pojo.Unit;
import com.hand.test_26850.vo.EmpVo;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee login(String emp_code, String password){
        Example example = new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("emp_code",emp_code);
        criteria.andEqualTo("password",password);
        Employee employee = employeeMapper.selectOneByExample(example);
        return employee;
    }

    public List<Employee> selectEmps(Employee employee){
        Example example=new Example(Employee.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(employee.getEmp_code())){
            criteria.andEqualTo("emp_code",employee.getEmp_code());
        }
        if (StringUtils.isNotEmpty(employee.getEmp_name())){
            criteria.andLike("emp_name","%"+employee.getEmp_name()+"%");
        }
        List<Employee> employees = employeeMapper.selectByExample(example);
        return employees;
    }

    public void deleteEmp(Integer emp_id){
        this.employeeMapper.deleteByPrimaryKey(emp_id);
    }

    public void deleteEmps(Integer[] emp_ids){
        for (int emp_id :emp_ids){
            this.employeeMapper.deleteByPrimaryKey(emp_id);
        }
    }

    public void updateEmp(Employee employee){
        this.employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void addEmp(Employee employee){
        this.employeeMapper.insertSelective(employee);
    }

    public Employee showEmpByEmpId(Integer emp_id){
        return this.employeeMapper.selectByPrimaryKey(emp_id);
    }

    public List<Employee> showEmpsByUnitId(Integer unit_id){
        Employee employee=new Employee();
        employee.setUnit_id(unit_id);
        return this.employeeMapper.select(employee);
    }





}
