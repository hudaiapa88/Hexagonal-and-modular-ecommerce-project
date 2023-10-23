package com.uc.order.infra.adapters.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.catalog.api.category.CategoryApi;
import com.uc.catalog.api.product.ProductApi;
import com.uc.order.domain.catalog.model.Product;
import com.uc.order.domain.catalog.port.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductApiAdapter implements ProductPort {

    private final ProductApi productApi;
    private final ObjectMapper objectMapper;

    @Override
    public Product getByProductId(Long id) {
        try {
            return objectMapper.readValue(productApi.getById(id),Product.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getByProductIds(List<Long> ids) {
        try {
            return objectMapper.readValue(productApi.getByIds(ids),new TypeReference<List<Product>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
