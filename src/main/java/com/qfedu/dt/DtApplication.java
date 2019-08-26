package com.qfedu.dt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qfedu.dt.dao")
public class DtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtApplication.class, args);
    }

}
