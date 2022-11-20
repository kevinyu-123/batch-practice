package com.practice.qtrproject.service;

import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.mapper.ProductMapper;
import com.practice.qtrproject.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ApiService {
    @Autowired
    private ProductMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(ProductDto dto) {
        Product product = Product.builder().build();
        BeanUtils.copyProperties(dto,product);

        mapper.saveProduct(product);

    }



}
