package com.practice.qtrproject.service;

import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.mapper.ApiMapper;
import com.practice.qtrproject.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiService {

    private final ApiMapper mapper;
    ApiService(ApiMapper mapper){
        this.mapper = mapper;
    }

    public void saveProduct(ProductDto dto) {
        Product product = Product.builder().build();

        BeanUtils.copyProperties(dto,product);

        mapper.saveProduct(product);

    }


}
