package com.practice.qtrproject.model.writer;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("작가 정보")
public class Writer {

    @Schema(description = "번호")
    private Integer no;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "내용")
    private String content;
}
