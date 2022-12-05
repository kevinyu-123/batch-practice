package com.practice.qtrproject.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {

    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Before("execution(* com.practice.qtrproject.controller.product.ProductController*(..))")
    public void doSomethingBefore() {
        logger.info("AOP Test : Before ");
    }

    @After("execution(* com.practice.qtrproject.controller.product.ProductController*(..)) ")
    public void doSomethingAfter() {
        logger.info("AOP Test : After");
    }

}
