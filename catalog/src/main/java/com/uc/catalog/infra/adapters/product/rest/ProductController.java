package com.uc.catalog.infra.adapters.product.rest;

import com.uc.catalog.domain.common.page.PageData;
import com.uc.catalog.domain.common.page.PageableProperties;
import com.uc.catalog.domain.common.usecase.VoidUseCaseHandler;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.*;
import com.uc.catalog.infra.adapters.product.rest.request.CreateProductRequest;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductResponseMapper;
import com.uc.catalog.infra.adapters.product.rest.response.ProductResponse;
import  com.uc.catalog.domain.common.usecase.UseCaseHandler;;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Transactional("catalogTransactionManager")
public class ProductController {

    private final UseCaseHandler<Product, CreateProductUseCase> createProductRequestUseCaseHandler;
    private final ProductToProductResponseMapper productToProductResponseMapper;
    private final UseCaseHandler<Product, GetProductByProductIdUseCase> getProductByProductIdUseCaseUseCaseHandler;
    private final   UseCaseHandler<PageData<Product>,GetAllProductPageUseCase> getAllProductPageUseCaseUseCaseHandler;
    private final VoidUseCaseHandler<DeleteProductUseCase> deleteProductUseCaseVoidUseCaseHandler;
    private final UseCaseHandler<PageData<Product>, GetProductByTitlePageUseCase> getProductByTitleUseCaseUseCaseHandler;
    private final UseCaseHandler<PageData<Product>, GetProductByCategoryTitlePageUseCase> getProductByCategoryTitleUseCaseUseCaseHandler;
    private final UseCaseHandler<PageData<Product>, GetProductByPriceRangePageUseCase> getProductByPriceRangeUseCaseUseCaseHandler;
    private final UseCaseHandler<List<String>, ProductAutocompleteUseCase> productAutocompleteUseCaseUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productToProductResponseMapper.convert(createProductRequestUseCaseHandler.handle(createProductRequest.toModel())));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(productToProductResponseMapper.convert(getProductByProductIdUseCaseUseCaseHandler.handle(new GetProductByProductIdUseCase(productId))));
    }

    /* @GetMapping("/pageable")
     public Page<OrderResponse> getAll(Pageable pageable){
         return orderService.getAll(pageable);
     }*/
    @GetMapping()
    @PageableAsQueryParam
    public ResponseEntity<PageData<ProductResponse>> getAll(@Parameter(hidden = true) PageableProperties pageable) {
        return ResponseEntity.ok(productToProductResponseMapper.convertPage(getAllProductPageUseCaseUseCaseHandler.handle(new GetAllProductPageUseCase(pageable))));
    }


    @GetMapping("/title/{title}")
    @PageableAsQueryParam
    public ResponseEntity<PageData<ProductResponse>> getByTitle(@PathVariable("title") String title,@Parameter(hidden = true) PageableProperties pageable) {
        return ResponseEntity.ok(productToProductResponseMapper.convertPage(getProductByTitleUseCaseUseCaseHandler.handle(new GetProductByTitlePageUseCase(title,pageable))));
    }

    @GetMapping("/category/title/{title}")
    @PageableAsQueryParam
    public ResponseEntity<PageData<ProductResponse>> getByCategoryTitle(@PathVariable("title") String title,@Parameter(hidden = true)PageableProperties pageable) {
        return ResponseEntity.ok(productToProductResponseMapper.convertPage(getProductByCategoryTitleUseCaseUseCaseHandler.handle(new GetProductByCategoryTitlePageUseCase(title,pageable))));
    }
    @GetMapping("/autocomplete/input/{input}")
    public ResponseEntity<List<String>> getAutocomplete(@PathVariable("input") String input) {
        return ResponseEntity.ok(productAutocompleteUseCaseUseCaseHandler.handle(new ProductAutocompleteUseCase(input)));
    }
    @GetMapping("/price-range")
    @PageableAsQueryParam
    public ResponseEntity<PageData<ProductResponse>> getByPriceRange(@RequestParam("min") Long min, @RequestParam("max") Long max,@Parameter(hidden = true)PageableProperties pageable) {
        return ResponseEntity.ok(productToProductResponseMapper.convertPage(getProductByPriceRangeUseCaseUseCaseHandler.handle(new GetProductByPriceRangePageUseCase(new BigDecimal(min),new BigDecimal(max),pageable))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteProductUseCaseVoidUseCaseHandler.handle(new DeleteProductUseCase(id));
        return ResponseEntity.ok().build();
    }
}
