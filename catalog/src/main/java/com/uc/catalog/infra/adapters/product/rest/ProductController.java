package com.uc.catalog.infra.adapters.product.rest;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import com.uc.catalog.domain.product.usecase.GetProductByProductIdUseCase;
import com.uc.catalog.infra.adapters.product.rest.request.CreateProductRequest;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductResponseMapper;
import com.uc.catalog.infra.adapters.product.rest.response.ProductResponse;
import com.uc.common.usecase.NoUseCaseHandler;
import com.uc.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Transactional("catalogTransactionManager")
public class ProductController {

    private final UseCaseHandler<Product, CreateProductUseCase> createProductRequestUseCaseHandler;
    private final ProductToProductResponseMapper productToProductResponseMapper;
    private final UseCaseHandler<Product, GetProductByProductIdUseCase> getProductByProductIdUseCaseUseCaseHandler;
    private final NoUseCaseHandler<List<Product>> getAllProductUseCaseHandler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productToProductResponseMapper.convert(createProductRequestUseCaseHandler.handle(createProductRequest.toModel())));
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(productToProductResponseMapper.convert(getProductByProductIdUseCaseUseCaseHandler.handle(new GetProductByProductIdUseCase(productId))))  ;
    }

    /* @GetMapping("/pageable")
     public Page<OrderResponse> getAll(Pageable pageable){
         return orderService.getAll(pageable);
     }*/
    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(productToProductResponseMapper.convertList(getAllProductUseCaseHandler.handle())) ;
    }
}
