package com.practice.qtrproject.model.product;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("상품 정보")
public class Product {
    @Id
    @Schema(description = "번호")
    private Integer no;

    @Schema(description = "가격")
    private Integer price;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "고유 번호")
    private String uniqueCode;

    @Schema(description = "작가명")
    private List<Integer> writerNo;

    @Schema(description = "역자명")
    private List<Integer> transNo;


    private Date regDate;

    private Date updDate;

    private Date delDate;

    private ProductInfo productInfo;
}
