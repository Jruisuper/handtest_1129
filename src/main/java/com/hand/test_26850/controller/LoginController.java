package com.hand.test_26850.controller;

import com.hand.test_26850.common.ResultObj;
import com.hand.test_26850.pojo.Employee;
import com.hand.test_26850.service.EmployeeService;
import com.hand.test_26850.service.UnitService;
import com.hand.test_26850.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UnitService unitService;

    @RequestMapping("login")
    public ResultObj login(String emp_code, String password, HttpSession session){
        try {
            Employee employee = employeeService.login(emp_code,password);
            if (employee == null){
                return ResultObj.LOGIN_ERROR_PASS;
            }
            session.setAttribute("emp_name",employee.getEmp_name());
            employee.setUnit_name(this.unitService.selectUnitByUintId(employee.getUnit_id()).getUnit_name());
            WebUtils.getSession().setAttribute("employee",employee);
            return ResultObj.LOGIN_SUCCESS;
        }catch (Exception e){
            return ResultObj.LOGIN_ERROR_PASS;
        }
    }
}
