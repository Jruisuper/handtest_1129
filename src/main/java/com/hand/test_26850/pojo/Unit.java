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
@Table(name = "unit_info")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_ID")
    private Integer unit_id;

    @Column(name = "UNIT_NAME")
    private String unit_name;

    @Column(name = "ENABLED_FLAG")
    private String enabled_flag;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATION_DATE")
    private Date creation_date;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "LAST_UPDATE_DATE")
    private Date last_update_date;


}
