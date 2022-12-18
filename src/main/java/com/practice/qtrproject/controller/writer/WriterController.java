package com.practice.qtrproject.controller.writer;

import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.dto.response.CommonRespDto;
import com.practice.qtrproject.service.WriterService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "작가")
@RequestMapping("/api/v1/writer")
@RestController
public class WriterController {

    private final WriterService writerService;

    @PostMapping("")
    public ResponseEntity<?> saveWriterInfo(@RequestBody WriterDto writerDto){

        return  new ResponseEntity<>(CommonRespDto.builder().code(1).msg("successfully saved to database").body(null).build(), HttpStatus.CREATED);
    }

}
