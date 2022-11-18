package com.practice.qtrproject.controller;

import com.practice.qtrproject.dto.CommonRespDto;
import com.practice.qtrproject.dto.ProductDto;
import com.practice.qtrproject.service.ApiService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Api("상품")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    private final ApiService service;

    @PostMapping("")
    public ResponseEntity<?> saveBook(@RequestBody @Valid ProductDto dto){
        service.saveProduct(dto);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("success").body(null).build(), HttpStatus.CREATED);
    }






}
