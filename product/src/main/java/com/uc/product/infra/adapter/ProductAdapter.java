package com.uc.product.infra.adapter;

import com.uc.product.domain.model.Product;
import com.uc.product.domain.port.ProductPort;
import com.uc.product.domain.usecase.CreateProductUseCase;
import com.uc.product.infra.jpa.entity.ProductEntity;
import com.uc.product.infra.jpa.repository.ProductRepository;
import com.uc.product.infra.mapper.ProductEntityToProductMapper;
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
