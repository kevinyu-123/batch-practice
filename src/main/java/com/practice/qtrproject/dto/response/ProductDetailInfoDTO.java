package com.practice.qtrproject.dto.response;

import com.practice.qtrproject.model.product.ProductInfo;
import com.practice.qtrproject.model.writer.Translator;
import com.practice.qtrproject.model.writer.Writer;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

public record ProductDetailInfoDTO(
        @Schema(description = "번호") Integer productNo,
        @Schema(description = "가격") Integer price,
        @Schema(description = "이름") String name,
        @Schema(description = "고유 번호") String uniqueCode,
        @Schema(description = "작가명") List<Integer> writerNoList,
        @Schema(description = "역자명") List<Integer> transNoList,
        @Schema(description = "등록일") Date regDate,
        @Schema(description = "수정일") Date updDate,
        @Schema(description = "삭제일") Date delDate,
        @Schema(description = "상품 상세 정보") ProductInfo productInfo,
        @Schema(description="삭제여부") Boolean delFlag,
         List<Writer> writerInfo,
         List<Translator> translatorInfo
        )
{ }
