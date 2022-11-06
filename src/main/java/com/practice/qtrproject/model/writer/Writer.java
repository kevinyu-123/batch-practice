package com.practice.qtrproject.model.writer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Writer {

    private Integer no;

    private String name;

    private String content;
}
