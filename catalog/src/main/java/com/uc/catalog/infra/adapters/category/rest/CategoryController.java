package com.uc.catalog.infra.adapters.category.rest;

import com.uc.category.domain.category.model.Category;
import com.uc.category.domain.category.usecase.CreateCategoryUseCase;
import com.uc.category.domain.category.usecase.DeleteCategoryUseCase;
import com.uc.category.domain.category.usecase.UpdateCategoryUseCase;
import com.uc.category.infra.mapper.CategoryToCategoryResponseMapper;
import com.uc.category.infra.rest.request.CreateCategoryRequest;
import com.uc.category.infra.rest.request.UpdateCategoryRequest;
import com.uc.category.infra.rest.response.CategoryResponse;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.common.usecase.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final UseCaseHandler<Category, CreateCategoryUseCase> createCategoryRequestUseCaseHandler;
    private final UseCaseHandler<Category, UpdateCategoryUseCase> updateCategoryRequestUseCaseHandler;
    private final VoidUseCaseHandler<DeleteCategoryUseCase> deleteCategoryUseCaseVoidUseCaseHandler;
    private final CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CategoryResponse> create(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convert(createCategoryRequestUseCaseHandler.handle(createCategoryRequest.toModel())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convert(updateCategoryRequestUseCaseHandler.handle(updateCategoryRequest.toModel(id))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {
        deleteCategoryUseCaseVoidUseCaseHandler.handle(new DeleteCategoryUseCase(id));
       return ResponseEntity.ok().build();
    }
}
