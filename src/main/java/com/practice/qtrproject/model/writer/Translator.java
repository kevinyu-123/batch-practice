package com.practice.qtrproject.model.writer;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value= "작가 정보", description = "db에 저장된 작가의 정보를 가진 도메인 class")
public class Translator {

    @Schema(description = "번호")
    private Integer translatorNo;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "내용")
    private String content;

    @Schema(description = "저장일")
    private Date regDate;

    @Schema(description = "수정일")
    private Date updDate;

}