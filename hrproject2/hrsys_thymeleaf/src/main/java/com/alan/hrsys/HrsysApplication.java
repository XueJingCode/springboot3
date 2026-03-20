package com.alan.hrsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alan.hrsys.dao")//扫描dao
public class HrsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrsysApplication.class, args);
    }

}
