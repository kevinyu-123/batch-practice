package com.practice.qtrproject.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BatchMapper {

    public void deleteByFlag();
}
