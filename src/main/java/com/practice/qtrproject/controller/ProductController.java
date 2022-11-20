package com.practice.qtrproject.controller;

import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.ApiService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Api("상품")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    private final ApiService service;

    @PostMapping("")
    public ResponseEntity<?> saveBook(@RequestBody ProductDto dto){
        service.saveProduct(dto);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getProductList(){

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("product list").body(service.getList()).build(),HttpStatus.OK);
    }




}
