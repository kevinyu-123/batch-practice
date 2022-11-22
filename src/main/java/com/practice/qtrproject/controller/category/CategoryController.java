package com.practice.qtrproject.controller.category;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@Api(tags = "카테고리")
@RequestMapping("/api/v1/cat")
@RestController
public class CategoryController {
}
