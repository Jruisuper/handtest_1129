package com.hand.test_26850.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转页面
 */
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("login")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("emps")
    public String toEmpsPage(){
        return "emps";
    }

    @RequestMapping("units")
    public String toUnits(){
        return "units";
    }
}
