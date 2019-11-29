package com.hand.test_26850.vo;

import com.hand.test_26850.pojo.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class EmpVo extends Employee {

    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=3;

    private Integer[] ids;//接收多个ID


}
