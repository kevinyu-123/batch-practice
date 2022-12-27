package com.practice.qtrproject.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReqWriterInfoUpdDto {

    @Schema(description = "이름")
    private String name;

    @Schema(description = "내용")
    private String content;

}
