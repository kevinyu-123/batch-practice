package com.practice.qtrproject.controller.writer;

import com.practice.qtrproject.dto.request.ReqWriterInfoUpdDto;
import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.WriterService;
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
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "작가")
@RequestMapping("/api/v1/writer")
@RestController
public class WriterController {

    private final WriterService writerService;


    @ApiOperation(value = "작가 정보 등록", notes = "작가 정보 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false)
    })
    @PostMapping("")
    public ResponseEntity<?> saveWriterInfo(@RequestBody @Valid WriterDto writerDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<String,String>();
            for(FieldError fe : bindingResult.getFieldErrors()){
                errorMap.put(fe.getField(),fe.getDefaultMessage());
            }
            log.info("errorMap: "+ errorMap.toString());
            throw new RuntimeException(errorMap.toString());
        }
        writerService.saveWriterInfo(writerDto);
        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "작가 정보 업데이트", notes = "db에 저장된 정보를 바로 업데이트")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false)
    })
    @PatchMapping("")
    public ResponseEntity<?> updateWriterInfo(@RequestBody  @Valid ReqWriterInfoUpdDto updDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<String,String>();
            for(FieldError fe : bindingResult.getFieldErrors()){
                errorMap.put(fe.getField(),fe.getDefaultMessage());
            }
            log.info("errorMap: "+ errorMap.toString());
            throw new RuntimeException(errorMap.toString());
        }
        writerService.updateWriterInfo(updDto);

        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully updated").body(null).build(), HttpStatus.OK);

    }

    @ApiOperation(value = "삭제 처리", notes = "db에 저장된 작가 정보를 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "accessToken", dataTypeClass = String.class, required = false)
    })
    @DeleteMapping("/{writerNo}")
    public ResponseEntity<?> deleteWriterInfo(@PathVariable @Positive Integer writerNo) throws Exception {
        writerService.deleteWriter(writerNo);
        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully deleted").body(null).build(), HttpStatus.OK);
    }


}
