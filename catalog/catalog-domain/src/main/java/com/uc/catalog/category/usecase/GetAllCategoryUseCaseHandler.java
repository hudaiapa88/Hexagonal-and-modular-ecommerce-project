package com.uc.catalog.category.usecase;


import com.uc.catalog.common.DomainComponent;
import com.uc.catalog.common.usecase.NoUseCaseHandler;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.category.port.CategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class GetAllCategoryUseCaseHandler implements NoUseCaseHandler<List<Category>> {
    private final CategoryPort categoryPort;

    @Override
    public List<Category> handle() {
        return categoryPort.getAll();
    }
}
