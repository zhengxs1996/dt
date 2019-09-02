package com.qfedu.dt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.qfedu.dt.dao")
@ServletComponentScan //扫描servlet相关的注解
public class DtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtApplication.class, args);
    }

}
