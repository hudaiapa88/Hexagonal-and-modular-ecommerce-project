package com.uc.catalog.domain.product.usecase.query;

import com.uc.catalog.domain.common.page.PageableProperties;
import  com.uc.catalog.domain.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class GetAllProductPageUseCase implements UseCase {
    private PageableProperties pageableProperties;
}
