package com.practice.qtrproject.model.product;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("상품 부가 정보")
public class ProductInfo {

    private Integer discountRate;

    private Integer savingRate;

    private Integer valuation;


}
