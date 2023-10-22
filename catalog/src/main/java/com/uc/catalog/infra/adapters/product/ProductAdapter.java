package com.uc.catalog.infra.adapters.product;

import com.uc.catalog.domain.category.model.Category;
import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.port.ProductPort;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import com.uc.catalog.infra.adapters.product.jpa.entity.ProductEntity;
import com.uc.catalog.infra.adapters.product.jpa.repository.ProductRepository;
import com.uc.catalog.infra.adapters.product.mapper.ProductEntityToProductMapper;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductEntityMapper;
import com.uc.common.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final ProductEntityToProductMapper productEntityToProductMapper;
    private final ProductToProductEntityMapper productToProductEntityMapper;

    @Override
    public Product getById(Long id) {
       return productEntityToProductMapper.convert(findById(id));
    }

    @Override
    public List<Product> getByIds(List<Long> ids) {
        return productEntityToProductMapper.convertList(productRepository.findAllById(ids));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity=productRepository.save(productToProductEntityMapper.convert(product));
        return productEntityToProductMapper.convert(productEntity);
    }

    @Override
    public List<Product> getAll() {
        return productEntityToProductMapper.convertList(productRepository.findAll());
    }

    private ProductEntity findById(Long id){
        return  productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Ürün bulunamadı"));
    }
}
