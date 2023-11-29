package com.uc.catalog.domain.product.usecase;

import com.uc.common.page.PageableProperties;
import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class GetProductByCategoryTitlePageUseCase implements UseCase {
    private String categoryTitle;
    private PageableProperties pageableProperties;
}
