package com.practice.qtrproject.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer no;

    private Integer price;

    private String name;

    private String uniqueCode;

    private List<Integer> writerNo;

    private List<Integer> transNo;

    private Date regDate;

    private Date updDate;

    private Date delDate;

    private ProductInfo productInfo;
}
