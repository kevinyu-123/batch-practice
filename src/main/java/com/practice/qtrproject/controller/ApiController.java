package com.practice.qtrproject.controller;

import com.practice.qtrproject.dto.request.RedisTestDto;
import com.practice.qtrproject.repository.RedisRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "테스트 컨트롤러")
@RequestMapping("/api/v1")
@RestController
public class ApiController {

    @Autowired
    RedisRepository redisRepository;
    @GetMapping("/test")
    public String testApi(){
        return "connection test";
    }


    @GetMapping("/redis")
    public String getTestRedis(){

        return redisRepository.findAll().toString();
    }

    @PostMapping("/redis")
    public String setTestRedis(@RequestBody RedisTestDto dto){

        return redisRepository.save(dto).toString();
    }


}
