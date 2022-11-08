package com.practice.qtrproject.controller;

import com.practice.qtrproject.service.ApiService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@ApiModel("API")
public class ApiController {

    private final ApiService service;







}
