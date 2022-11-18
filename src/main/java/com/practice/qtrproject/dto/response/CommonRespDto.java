package com.practice.qtrproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonRespDto<T> {

    private Integer code; // 1:성공, 2:실패

    private String msg; //에러 또는 성공 메세지 제공

    private T body;


}

