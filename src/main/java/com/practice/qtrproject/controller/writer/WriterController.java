package com.practice.qtrproject.controller.writer;

import com.practice.qtrproject.dto.request.ReqWriterInfoUpdDto;
import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.WriterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "작가")
@RequestMapping("/api/v1/writer")
@RestController
public class WriterController {

    private final WriterService writerService;


    @ApiOperation(value = "작가 정보 등록", notes = "작가 정보 등록")
    @PostMapping("")
    public ResponseEntity<?> saveWriterInfo(@RequestBody @Valid WriterDto writerDto, BindingResult bindingResult){
        writerService.saveWriterInfo(writerDto);
        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "작가 정보 업데이트", notes = "db에 저장된 정보를 바로 업데이트")
    @PatchMapping("")
    public ResponseEntity<?> updateWriterInfo(@RequestBody  @Valid ReqWriterInfoUpdDto updDto, BindingResult bindingResult) throws Exception{
        writerService.updateWriterInfo(updDto);

        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully updated").body(null).build(), HttpStatus.OK);

    }

    @ApiOperation(value = "삭제 처리", notes = "db에 저장된 작가 정보를 삭제")
    @DeleteMapping("/{writerNo}")
    public ResponseEntity<?> deleteWriterInfo(@PathVariable @Positive Integer writerNo) throws Exception {
        writerService.deleteWriter(writerNo);
        return new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully deleted").body(null).build(), HttpStatus.OK);
    }


}
