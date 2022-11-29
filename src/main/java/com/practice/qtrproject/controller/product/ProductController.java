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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<String,String>();
            for(FieldError fe : bindingResult.getFieldErrors()){
                errorMap.put(fe.getField(),fe.getDefaultMessage());
            }
            log.info("errorMap: "+ errorMap.toString());
            throw new RuntimeException(errorMap.toString());
        }
        service.saveProduct(dto);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "상품 리스트 조회", notes = "DB를 통하여 상품정보를 리스트형식으로 불러온다")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false) //TODO: 차후 jwt 토큰 사용
    })
    @GetMapping("")
    public ResponseEntity<?> getProductList(@RequestParam int pageSize, @RequestParam int currentPage){

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("product list").body(service.getList()).build(),HttpStatus.OK);
    }
    @ApiOperation(value = "상품 del_date 업데이트 처리", notes = "del_date 업데이트 후 배치를 통하여 삭제 처리")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false)
    })
    @PutMapping("/{productNo}")
    public ResponseEntity<?> updateDelDate(@PathVariable Integer productNo){
        service.updateDelDate(productNo);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully updated").body(null).build(),HttpStatus.OK);
    }
    @ApiOperation(value = "바로 삭제 처리", notes = "db에 저장된 정보를 바로 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false)
    })
    @DeleteMapping("/{productNo}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productNo){
        service.deleteProduct(productNo);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully deleted").body(null).build(),HttpStatus.NO_CONTENT);

    }

}
