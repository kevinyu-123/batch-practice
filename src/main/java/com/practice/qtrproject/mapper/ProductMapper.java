package com.practice.qtrproject.mapper;

import com.practice.qtrproject.dto.request.PageParamDto;
import com.practice.qtrproject.dto.request.SearchParamRecordDTO;
import com.practice.qtrproject.dto.response.ResultProductDetailInfoDto;
import com.practice.qtrproject.model.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    public void saveProduct( Product product);
    public List<Product> getList(@Param("searchParamDto") SearchParamRecordDTO searchParamDto, @Param("pageParamDto") PageParamDto pageParamDto);
    public void deleteProduct(@Param("no") Integer productNo);
    public void updateDelDate(@Param("no") Integer productNo);
    public ResultProductDetailInfoDto getDetailInfo(@Param("no") Integer productNo);

    public int checkVal(Integer productNo);
}
