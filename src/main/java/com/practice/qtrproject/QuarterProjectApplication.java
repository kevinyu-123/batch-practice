package com.practice.qtrproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class QuarterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuarterProjectApplication.class, args);
    }

}
