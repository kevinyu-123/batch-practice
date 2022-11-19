package com.practice.qtrproject.mapper;

import com.practice.qtrproject.model.product.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    public void saveProduct( Product product);
}
