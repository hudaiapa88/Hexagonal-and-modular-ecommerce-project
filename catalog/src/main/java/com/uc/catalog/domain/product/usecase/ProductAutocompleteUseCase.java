package com.uc.catalog.domain.product.usecase;

import com.uc.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductAutocompleteUseCase implements UseCase {
    private String input;
}
