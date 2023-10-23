package com.uc.catalog.api.category;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.usecase.GetByCategoryIdUseCase;
import com.uc.common.usecase.UseCaseHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryApi {

    private final UseCaseHandler<Category, GetByCategoryIdUseCase> categoryIdUseCaseUseCaseHandler;
    private final ObjectMapper objectMapper;
    String findById(Long id)  {
        try {
            return objectMapper.writeValueAsString(categoryIdUseCaseUseCaseHandler.handle(new GetByCategoryIdUseCase(id)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
