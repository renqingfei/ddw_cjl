package com.example.ddw_cjl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ddw_cjl.dao")
public class DdwCjlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdwCjlApplication.class, args);
    }

}
