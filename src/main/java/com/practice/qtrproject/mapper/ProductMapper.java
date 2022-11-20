package com.practice.qtrproject.mapper;

import com.practice.qtrproject.model.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public void saveProduct( Product product);

    public List<Product> getList();
}
