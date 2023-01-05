package com.practice.qtrproject.handler;

import com.practice.qtrproject.dto.response.CommonRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> apiException(RuntimeException e){
        return new ResponseEntity<>(CommonRespDto.builder().code(2).msg(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

}
