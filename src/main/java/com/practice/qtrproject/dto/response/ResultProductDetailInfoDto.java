package com.practice.qtrproject.dto.response;

import com.practice.qtrproject.model.product.ProductInfo;
import com.practice.qtrproject.model.writer.Translator;
import com.practice.qtrproject.model.writer.Writer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultProductDetailInfoDto {

    @Schema(description = "번호")
    private Integer productNo;

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
    private List<Writer> writerInfo;
    private List<Translator> translatorInfo;


}
