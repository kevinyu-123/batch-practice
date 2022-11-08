package com.practice.qtrproject.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "할인율")
    private Integer discountRate;

    @Schema(description = "적립율")
    private Integer savingRate;

    @Schema(description = "평점")
    private Integer valuation;


}
