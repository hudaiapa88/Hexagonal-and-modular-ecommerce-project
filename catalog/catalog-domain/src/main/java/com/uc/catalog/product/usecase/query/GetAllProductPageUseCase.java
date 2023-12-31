package com.uc.catalog.product.usecase.query;

import com.uc.catalog.common.page.PageableProperties;
import com.uc.catalog.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllProductPageUseCase implements UseCase {
    private PageableProperties pageableProperties;
}
