package com.uc.catalog.product.usecase.query;


import com.uc.catalog.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductAutocompleteUseCase implements UseCase {
    private String input;
}
