package com.uc.catalog.infra.adapters.product.rest;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import com.uc.catalog.infra.adapters.product.rest.request.CreateProductRequest;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductResponseMapper;
import com.uc.catalog.infra.adapters.product.rest.response.ProductResponse;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final UseCaseHandler<Product, CreateProductUseCase> createProductRequestUseCaseHandler;
    private final ProductToProductResponseMapper productToProductResponseMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productToProductResponseMapper.convert(createProductRequestUseCaseHandler.handle(createProductRequest.toModel())));
    }

}
