package com.practice.qtrproject.dto;

import com.practice.qtrproject.model.product.ProductInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class ProductDto {

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

    @Schema(description = "상품 상세 정보")
    private ProductInfo productInfo;


}
