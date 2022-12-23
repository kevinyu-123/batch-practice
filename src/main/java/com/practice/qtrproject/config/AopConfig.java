package com.practice.qtrproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AopConfig {
    private static final Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Before("execution(* com.practice.qtrproject.controller.product.ProductController.*.*(..))")
    public void doSomethingBefore() {
        log.info("AOP Test : Before ");
    }

    @After("execution(* com.practice.qtrproject.controller.product.ProductController.*.*(..)) ")
    public void doSomethingAfter() {
        log.info("AOP Test : After");
    }

}
/*
    @Before : 조인포인트 전에 실행
    @AfterReturning : 조인포인트에서 성공적으로 리턴 된 후 실행
    @AfterThrowing : 예외가 발생하였을 경우 실행
    @After : 조인포인트에서 메서드의 실행결과에 상관없이 무조건 실행
    @Around : 조인포인트의 전 과정(전, 후)에 수행
 */