package com.practice.qtrproject.service;

import com.practice.qtrproject.dto.request.ReqWriterInfoUpdDto;
import com.practice.qtrproject.dto.request.WriterDto;
import com.practice.qtrproject.mapper.WriterMapper;
import com.practice.qtrproject.model.writer.Writer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ApiException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WriterService {

    private final WriterMapper writerMapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveWriterInfo(WriterDto writerDto) {

        Writer writer = Writer.builder().build();
        BeanUtils.copyProperties(writerDto,writer);
        log.info("writer : {}",writer);

        try {
            writerMapper.saveInfo(writer);
        }catch (Exception e){
            log.error("error occured : {}", e.getMessage());
            throw new ApiException(e);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void updateWriterInfo(ReqWriterInfoUpdDto updDto) {
        int valueCount = writerMapper.checkVal(updDto.getWriterNo());
        if(valueCount == 0){
            throw new ApiException("no value");
        }
        try {
            writerMapper.updateInfo(updDto);
        }catch (Exception e){
            log.error("error occurred : {}", e.getMessage());
            throw new ApiException(e);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void deleteWriter(Integer writerNo) {
        int valueCount = writerMapper.checkVal(writerNo);
        if(valueCount == 0){
            throw new ApiException("no value");
        }
        try {
            writerMapper.deleteWriterInfo(writerNo);
        }catch (Exception e){
            log.error("error on deleting : {}", e.getMessage());
            throw new ApiException(e);
        }
    }


}
