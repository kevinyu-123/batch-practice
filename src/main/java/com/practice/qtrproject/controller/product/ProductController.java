package com.practice.qtrproject.controller.product;

import com.practice.qtrproject.dto.request.PageParamDto;
import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.dto.request.SearchParamRecordDTO;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    @PostMapping("")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductDto dto, BindingResult bindingResult){
        service.saveProduct(dto);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "상품 상세 정보", notes = "상품과 저자 정보 가져오기")
    @GetMapping("/{productNo}")
    public ResponseEntity<?> getProductDetailInfo(@PathVariable Integer productNo){

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("product detail Info").body(service.getDetailInfo(productNo)).build(),HttpStatus.OK);
    }

    @ApiOperation(value = "상품 리스트 조회", notes = "DB를 통하여 상품정보를 리스트형식으로 불러온다")
    @GetMapping("")
    public ResponseEntity<?> getProductList(SearchParamRecordDTO searchParamDto, PageParamDto pageParamDto){

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("product list").body(service.getList(searchParamDto, pageParamDto)).build(),HttpStatus.OK);
    }
    @ApiOperation(value = "상품 del_date 업데이트 처리", notes = "del_date 업데이트 후 배치를 통하여 삭제 처리")
    @PutMapping("/{productNo}")
    public ResponseEntity<?> updateDelDate(@PathVariable Integer productNo){
        service.updateDelDate(productNo);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully updated").body(null).build(),HttpStatus.OK);
    }
    @ApiOperation(value = "바로 삭제 처리", notes = "db에 저장된 정보를 바로 삭제")
    @DeleteMapping("/{productNo}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productNo){
        service.deleteProduct(productNo);

        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully deleted").body(null).build(),HttpStatus.OK);

    }


}
