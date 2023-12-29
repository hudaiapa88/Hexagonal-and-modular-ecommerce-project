package com.uc.catalog.domain.product.usecase.query;


import com.uc.catalog.domain.common.page.PageableProperties;
import  com.uc.catalog.domain.common.usecase.UseCase;
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
