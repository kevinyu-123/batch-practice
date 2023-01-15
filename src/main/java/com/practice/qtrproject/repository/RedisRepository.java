package com.practice.qtrproject.repository;

import com.practice.qtrproject.dto.request.RedisTestDto;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<RedisTestDto, String> {

}
