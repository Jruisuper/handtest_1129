package com.hand.test_26850.vo;

import com.hand.test_26850.pojo.Unit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnitVo extends Unit {

    private static final long serialVersionUID = 1L;


    private Integer page=1;
    private Integer limit=3;

}
