package com.practice.qtrproject.service;

import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.mapper.WriterMapper;
import com.practice.qtrproject.model.writer.Writer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterMapper writerMapper;

    public void saveWriterInfo(WriterDto writerDto) {

        Writer writer = Writer.builder().build();
        BeanUtils.copyProperties(writerDto,writer);
        log.info("writer : {}",writer);

        try {
            writerMapper.saveInfo(writer);
        }catch (Exception e){
            log.error("error occured : {}", e.getMessage());
        }

    }
}
