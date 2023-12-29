package com.uc.catalog.domain.product.usecase.query;

import com.uc.catalog.domain.common.page.PageableProperties;
import  com.uc.catalog.domain.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetProductByCategoryTitlePageUseCase implements UseCase {
    private String categoryTitle;
    private PageableProperties pageableProperties;
}
