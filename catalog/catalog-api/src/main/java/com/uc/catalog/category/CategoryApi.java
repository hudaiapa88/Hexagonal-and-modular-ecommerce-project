package com.uc.catalog.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.common.usecase.UseCaseHandler;
import com.uc.catalog.category.usecase.GetCategoryByCategoryIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryApi {

    private final UseCaseHandler<Category, GetCategoryByCategoryIdUseCase> categoryIdUseCaseUseCaseHandler;
    private final ObjectMapper objectMapper;
    String findById(Long id)  {
        try {
            return objectMapper.writeValueAsString(categoryIdUseCaseUseCaseHandler.handle(new GetCategoryByCategoryIdUseCase(id)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
