package com.practice.qtrproject.dto.request;

import com.practice.qtrproject.model.product.ProductInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDto {

    @Schema(description = "가격")
    @NotNull
    private Integer price;

    @Schema(description = "이름")
    @NotBlank
    private String name;

    @Schema(description = "고유 번호")
    @NotBlank
    private String uniqueCode;

    @Schema(description = "작가명")
    private List<Integer> writerNo;

    @Schema(description = "역자명")
    private List<Integer> transNo;

    @Schema(description = "상품 상세 정보")
    private ProductInfo productInfo;

}
