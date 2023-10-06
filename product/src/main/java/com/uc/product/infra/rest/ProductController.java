package com.uc.product.infra.rest;

import com.uc.product.domain.model.Product;
import com.uc.product.domain.usecase.CreateProductUseCase;
import com.uc.product.infra.mapper.ProductToProductResponseMapper;
import com.uc.product.infra.rest.request.CreateProductRequest;
import com.uc.product.infra.rest.response.ProductResponse;
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
