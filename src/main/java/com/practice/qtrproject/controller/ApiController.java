package com.practice.qtrproject.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@Api("test 컨트롤러")
@RequestMapping("/api/v1")
@RestController
public class ApiController {

    @GetMapping("/test")
    public String testApi(){
        return "connection test";
    }





}
