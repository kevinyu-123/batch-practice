package com.practice.qtrproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class ValidationCheckAopConfig {

    @Around("execution(* com.practice.qtrproject.controller..*Controller.*(..))")
    public Object validCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String type = proceedingJoinPoint.getSignature().getDeclaringTypeName(); //controller
        String method = proceedingJoinPoint.getSignature().getName(); // method

        log.info("type : {}", type);
        log.info("method : {}", method);

        Object[] args = proceedingJoinPoint.getArgs();

        for(Object arg: args){
            if(arg instanceof BindingResult){ // find binding result arg is available
                BindingResult bindingResult = (BindingResult) arg;
                if(bindingResult.hasErrors()){
                    Map<String,String> errorMap = new HashMap<String,String>();
                    for(FieldError fe : bindingResult.getFieldErrors()){
                        errorMap.put(fe.getField(),fe.getDefaultMessage());
                    }
                    log.info("errorMap: "+ errorMap.toString());
                    throw new RuntimeException(errorMap.toString());
                }
            }
        }

        return proceedingJoinPoint.proceed(); // 함수를 계속 실행

    }



}
