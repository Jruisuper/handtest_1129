package com.hand.test_26850.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "employee_info")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Integer emp_id;

    @Column(name = "EMP_CODE")
    private String emp_code;

    @Column(name = "EMP_NAME")
    private String emp_name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SEX")
    private String sex;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "UNIT_ID")
    private Integer unit_id;

    @Column(name = "EMP_JOB")
    private String emp_job;

    @Column(name = "SALARY")
    private String salary;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATION_DATE")
    private Date creation_date;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE")
    private Date last_update_date;

    @Transient
    private String unit_name;

}
