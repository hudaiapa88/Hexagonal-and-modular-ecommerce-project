package com.uc.category.infra.rest;

import com.uc.category.domain.model.Category;
import com.uc.category.domain.usecase.CreateCategoryUseCase;
import com.uc.category.infra.mapper.CategoryToCategoryResponseMapper;
import com.uc.category.infra.rest.request.CreateCategoryRequest;
import com.uc.category.infra.rest.response.CategoryResponse;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final UseCaseHandler<Category, CreateCategoryUseCase> createCategoryRequestUseCaseHandler;
    private final CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryResponse> create(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convert(createCategoryRequestUseCaseHandler.handle(createCategoryRequest.toModel())));
    }

}
