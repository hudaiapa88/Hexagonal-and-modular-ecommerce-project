package com.uc.catalog.infra.adapters.product;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import com.uc.catalog.infra.adapters.product.jpa.entity.ProductEntity;
import com.uc.catalog.infra.adapters.product.jpa.repository.ProductRepository;
import com.uc.catalog.infra.adapters.product.mapper.ProductEntityToProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ProductRepository categoryRepository;
    private final ProductEntityToProductMapper categoryEntityToProductMapper;

    @Override
    public Product create(CreateProductUseCase createProductUseCase) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(createProductUseCase.getTitle());
        return categoryEntityToProductMapper.convert(categoryRepository.save(productEntity));
    }
}
