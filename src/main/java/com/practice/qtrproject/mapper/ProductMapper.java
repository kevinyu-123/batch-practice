package com.practice.qtrproject.mapper;

import com.practice.qtrproject.model.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    public void saveProduct( Product product);

    public List<Product> getList();

    public void deleteProduct(@Param("no") Integer productNo);
   public void updateDelDate(@Param("no") int productNo);
}
