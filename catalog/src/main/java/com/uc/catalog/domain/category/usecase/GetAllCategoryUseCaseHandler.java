package com.uc.catalog.domain.category.usecase;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.port.CategoryPort;
import com.uc.common.DomainComponent;
import com.uc.common.usecase.NoUseCaseHandler;
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
