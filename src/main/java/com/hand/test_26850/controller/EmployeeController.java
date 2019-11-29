package com.hand.test_26850.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.test_26850.common.DataGridView;
import com.hand.test_26850.common.ResultObj;
import com.hand.test_26850.pojo.Employee;
import com.hand.test_26850.service.EmployeeService;
import com.hand.test_26850.service.UnitService;
import com.hand.test_26850.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UnitService unitService;

    @RequestMapping("showEmps")
    @ResponseBody
    public DataGridView showAllUsers(EmpVo empVo){
        PageHelper.startPage(empVo.getPage(),empVo.getLimit());
        Employee employee=new Employee();
        employee.setEmp_code(empVo.getEmp_code());
        employee.setEmp_name(empVo.getEmp_name());
        List<Employee> employees = this.employeeService.selectEmps(employee);
        for (Employee emp: employees){
            emp.setUnit_name(unitService.selectUnitByUintId(emp.getUnit_id()).getUnit_name());
        }
//        System.out.println("========================================");
//        System.out.println(employees);
        PageInfo<Employee> pageInfo=new PageInfo<>(employees);
        return new DataGridView(pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("addEmp")
    @ResponseBody
    public ResultObj addEmp(EmpVo empVo, @RequestParam String birthday){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date birth = format.parse(birthday);
            empVo.setBirthday(birth);
            empVo.setCreation_date(new Date());
            empVo.setLast_update_date(new Date());
            this.employeeService.addEmp(empVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("delEmp")
    @ResponseBody
    public ResultObj delEmp(Integer emp_id){
        try {
            this.employeeService.deleteEmp(emp_id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("batchDelEmp")
    @ResponseBody
    public ResultObj batchDelEmp(EmpVo empVo){
        try {
            this.employeeService.deleteEmps(empVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    @RequestMapping("showEmpsByUnitId")
    public String showEmpsByUnitId(Integer unit_id,Model model){
        List<Employee> employees = this.employeeService.showEmpsByUnitId(unit_id);
        for (Employee emp :employees){
            emp.setUnit_name(unitService.selectUnitByUintId(unit_id).getUnit_name());
        }
        model.addAttribute("emps",employees);
        return "unit_emps";
    }

    @RequestMapping("showEmpByEmpId")
    public String showEmpByEmpId(Integer emp_id, Model model){
        Employee employee = employeeService.showEmpByEmpId(emp_id);
        model.addAttribute("emp",employee);
        return "userinfo";
    }

    @RequestMapping("selectEmpByEmpId")
    @ResponseBody
    public Employee selectEmpByEmpId(Integer emp_id){
        return employeeService.showEmpByEmpId(emp_id);
    }


    @RequestMapping("updateEmp")
    @ResponseBody
    public ResultObj updaeEmp(EmpVo empVo){
        try {
            empVo.setLast_update_date(new Date());
            this.employeeService.updateEmp(empVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


}
