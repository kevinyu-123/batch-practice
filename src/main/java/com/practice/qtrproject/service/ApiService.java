package com.practice.qtrproject.service;

import com.practice.qtrproject.dto.request.PageParamDto;
import com.practice.qtrproject.dto.request.ProductDto;
import com.practice.qtrproject.dto.request.SearchParamDto;
import com.practice.qtrproject.mapper.ProductMapper;
import com.practice.qtrproject.model.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ApiService {
    @Autowired
    private ProductMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(ProductDto dto) {
        Product product = Product.builder().build();
        BeanUtils.copyProperties(dto,product);
        log.info("product : {}", product);

        mapper.saveProduct(product);

    }
    public List<Product> getList(SearchParamDto searchParamDto, PageParamDto pageParamDto) {

        return mapper.getList(searchParamDto,pageParamDto);
    }

    public void updateDelDate(int productNo){

        mapper.updateDelDate(productNo);
    }

    public void deleteProduct(Integer productNo)  {

        mapper.deleteProduct(productNo);
    }
}
