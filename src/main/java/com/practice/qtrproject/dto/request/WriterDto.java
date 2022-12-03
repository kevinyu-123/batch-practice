package com.practice.qtrproject.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "작가 정보")
public class WriterDto {

    @Schema(description = "이름")
    private String name;

    @Schema(description = "내용")
    private String content;
    
}
