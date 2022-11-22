package com.practice.qtrproject.controller.product;

import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "상품")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    private final ApiService service;

    @ApiOperation(value = "상품 저장", notes = "상품정보를 DB에 저장")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false) //TODO: 차후 jwt 토큰 사용
    })
    @PostMapping("")
    public ResponseEntity<?> saveBook(@RequestBody @Valid ProductDto dto){
        service.saveProduct(dto);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }
    @ApiOperation(value = "상품 리스트 조회", notes = "DB를 통하여 상품정보를 리스트형식으로 불러온다")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false) //TODO: 차후 jwt 토큰 사용
    })
    @GetMapping("")
    public ResponseEntity<?> getProductList(){

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("product list").body(service.getList()).build(),HttpStatus.OK);
    }




}
