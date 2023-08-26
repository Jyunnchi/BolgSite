package com.wrz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.wrz.mapper")
@ComponentScan(basePackages={"com.wrz.*"})
public class BolgApplication {

    public static void main(String[] args) {

        SpringApplication.run(BolgApplication.class, args);

    }

}
