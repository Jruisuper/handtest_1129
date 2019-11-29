package com.hand.test_26850;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hand.test_26850.mapper")
public class Test26850Application {

    public static void main(String[] args) {
        SpringApplication.run(Test26850Application.class, args);
    }

}
