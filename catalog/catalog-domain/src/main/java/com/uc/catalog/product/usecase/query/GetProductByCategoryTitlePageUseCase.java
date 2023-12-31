package com.uc.catalog.product.usecase.query;

import com.uc.catalog.common.page.PageableProperties;
import com.uc.catalog.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetProductByCategoryTitlePageUseCase implements UseCase {
    private String categoryTitle;
    private PageableProperties pageableProperties;
}
