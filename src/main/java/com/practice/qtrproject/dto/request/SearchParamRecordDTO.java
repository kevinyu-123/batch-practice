package com.practice.qtrproject.dto.request;

public record SearchParamRecordDTO(
        String regDate,
         String updDate,
         String delDate,
         String searchType,
         String value
    )
{ }
