package com.uc.catalog.category.usecase;


import com.uc.catalog.category.model.Category;
import com.uc.catalog.category.port.CategoryPort;
import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.UseCaseHandler;
//import  com.uc.catalog.common.DomainComponent;
;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateCategoryUseCaseHandler implements UseCaseHandler<Category, CreateCategoryUseCase> {

    private final CategoryPort categoryPort;
    @Override
    public Category handle(CreateCategoryUseCase createCategoryUseCase) {
       //Enterprise business rules
        Category category= new Category();
        category.setTitle(createCategoryUseCase.getTitle());
        return categoryPort.save(category);
    }
}
