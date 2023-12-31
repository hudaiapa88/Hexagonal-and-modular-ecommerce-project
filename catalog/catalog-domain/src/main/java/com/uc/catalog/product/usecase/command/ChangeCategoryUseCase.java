package com.uc.catalog.product.usecase.command;


import com.uc.catalog.common.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeCategoryUseCase implements UseCase {
    private Long id;
    private Long categoryId;
}
