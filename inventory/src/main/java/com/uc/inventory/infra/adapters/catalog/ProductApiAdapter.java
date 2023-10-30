package com.uc.inventory.infra.adapters.catalog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.inventory.domain.catalog.model.Product;
import com.uc.inventory.domain.catalog.port.ProductPort;
import com.uc.catalog.api.product.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("InventoryProductApiAdapter")
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
