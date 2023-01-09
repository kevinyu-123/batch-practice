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
@ApiModel(value = "상품 정보")
public class Product {
    @Id
    @Schema(description = "번호")
    private Integer productNo;

    @Schema(description = "가격")
    private Integer price;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "고유 번호")
    private String uniqueCode;

    @Schema(description = "작가명")
    private List<Integer> writerNoList;

    @Schema(description = "역자명")
    private List<Integer> transNoList;

    @Schema(description = "등록일")
    private Date regDate;

    @Schema(description = "수정일")
    private Date updDate;

    @Schema(description = "삭제일")
    private Date delDate;

    @Schema(description = "상품 상세 정보")
    private ProductInfo productInfo;

    @Schema(description="삭제여부")
    private Boolean delFlag;
}
