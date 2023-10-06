package com.uc.product.infra.rest;

import com.uc.product.domain.model.Category;
import com.uc.product.domain.usecase.CreateCategoryUseCase;
import com.uc.product.infra.mapper.CategoryToCategoryResponseMapper;
import com.uc.product.infra.rest.request.CreateCategoryRequest;
import com.uc.product.infra.rest.response.CategoryResponse;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
