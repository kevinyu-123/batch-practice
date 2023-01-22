package com.practice.qtrproject.service;


import com.practice.qtrproject.mapper.BatchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchMapper batchMapper;

    public void deleteByFlag(){
        batchMapper.deleteByFlag();
    }


}
