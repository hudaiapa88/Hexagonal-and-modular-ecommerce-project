package com.uc.catalog.infra.adapters.category.rest;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.category.usecase.*;
import com.uc.catalog.domain.common.usecase.NoUseCaseHandler;
import com.uc.catalog.domain.common.usecase.VoidUseCaseHandler;
import com.uc.catalog.infra.adapters.category.mapper.CategoryToCategoryResponseMapper;
import com.uc.catalog.infra.adapters.category.rest.request.CreateCategoryRequest;
import com.uc.catalog.infra.adapters.category.rest.request.UpdateCategoryRequest;
import com.uc.catalog.infra.adapters.category.rest.response.CategoryResponse;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
@Transactional("catalogTransactionManager")
public class CategoryController {

    private final UseCaseHandler<Category, CreateCategoryUseCase> createCategoryRequestUseCaseHandler;
    private final UseCaseHandler<Category, UpdateCategoryUseCase> updateCategoryRequestUseCaseHandler;
    private final VoidUseCaseHandler<DeleteCategoryUseCase> deleteCategoryUseCaseVoidUseCaseHandler;
    private final UseCaseHandler<Category, GetCategoryByCategoryIdUseCase> getByCategoryIdUseCaseVoidUseCaseHandler;
    private final NoUseCaseHandler<List<Category>> getAllCategoryUseCaseHandler;
    private final CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return categoryToCategoryResponseMapper.convert(createCategoryRequestUseCaseHandler.handle(createCategoryRequest.toUseCase()));
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convertList(getAllCategoryUseCaseHandler.handle()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convert(getByCategoryIdUseCaseVoidUseCaseHandler.handle(new GetCategoryByCategoryIdUseCase(id))));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return ResponseEntity.ok(categoryToCategoryResponseMapper.convert(updateCategoryRequestUseCaseHandler.handle(updateCategoryRequest.toUseCase(id))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id) {
        deleteCategoryUseCaseVoidUseCaseHandler.handle(new DeleteCategoryUseCase(id));
       return ResponseEntity.ok().build();
    }
}
