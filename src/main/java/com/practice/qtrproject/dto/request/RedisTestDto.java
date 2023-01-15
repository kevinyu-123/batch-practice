package com.practice.qtrproject.dto.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash
public class RedisTestDto {

    @Id
    private String productNo;

    private String uniqueCode;
}
