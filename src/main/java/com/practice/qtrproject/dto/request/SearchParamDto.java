package com.practice.qtrproject.dto.request;

import lombok.Data;

@Data
public class SearchParamDto {
    private String regDate;
    private String updDate;
    private String delDate;
    private String searchType;
    private String value;

}
