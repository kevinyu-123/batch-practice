package com.practice.qtrproject.mapper;

import com.practice.qtrproject.dto.request.ReqWriterInfoUpdDto;
import com.practice.qtrproject.model.writer.Writer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WriterMapper {
    public void saveInfo(Writer writer);
    public void updateInfo(ReqWriterInfoUpdDto updDto);
}
