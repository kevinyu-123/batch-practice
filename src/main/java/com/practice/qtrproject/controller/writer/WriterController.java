package com.practice.qtrproject.controller.writer;

import com.practice.qtrproject.dto.request.ReqWriterInfoUpdDto;
import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.WriterService;
import io.swagger.annotations.Api;
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
@Api(tags = "작가")
@RequestMapping("/api/v1/writer")
@RestController
public class WriterController {

    private final WriterService writerService;

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

    @PutMapping("")
    public ResponseEntity<?> updateWriterInfo(@RequestBody ReqWriterInfoUpdDto updDto){

        writerService.updateWriterInfo(updDto);

        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully updated").body(null).build(), HttpStatus.OK);

    }

}
