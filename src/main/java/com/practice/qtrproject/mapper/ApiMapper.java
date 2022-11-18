package com.practice.qtrproject.mapper;

import com.practice.qtrproject.model.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiMapper {
    public void saveProduct(@Param("product") Product product);







}
