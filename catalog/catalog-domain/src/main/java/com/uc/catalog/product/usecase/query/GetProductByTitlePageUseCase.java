package com.uc.catalog.product.usecase.query;

import com.uc.catalog.common.page.PageableProperties;
import com.uc.catalog.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetProductByTitlePageUseCase implements UseCase {
    private String title;
    private PageableProperties pageableProperties;
}
