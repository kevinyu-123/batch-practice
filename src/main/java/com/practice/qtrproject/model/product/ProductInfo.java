package com.practice.qtrproject.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    private Integer discountRate;

    private Integer savingRate;

    private Integer valuation;


}
