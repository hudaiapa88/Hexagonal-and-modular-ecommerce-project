package com.uc.catalog.domain.product.usecase;

import com.uc.common.page.PageableProperties;
import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetProductByTitlePageUseCase implements UseCase {
    private String title;
    private PageableProperties pageableProperties;
}
