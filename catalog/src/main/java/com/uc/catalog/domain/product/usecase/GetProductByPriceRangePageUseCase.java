package com.uc.catalog.domain.product.usecase;

import com.uc.common.page.PageableProperties;
import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class GetProductByPriceRangePageUseCase implements UseCase {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private PageableProperties pageableProperties;
}
