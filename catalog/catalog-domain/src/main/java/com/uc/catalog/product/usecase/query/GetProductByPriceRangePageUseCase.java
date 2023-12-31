package com.uc.catalog.product.usecase.query;


import com.uc.catalog.common.page.PageableProperties;
import com.uc.catalog.common.usecase.UseCase;
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
