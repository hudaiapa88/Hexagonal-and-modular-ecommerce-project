package com.uc.catalog.api.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.catalog.domain.product.port.ProductCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductApi {
    private final ProductCommandPort productCommandPort;
    private final ObjectMapper objectMapper;

    public String getById(Long id)  {
        try {
            return objectMapper.writeValueAsString(productCommandPort.getById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getByIds(List<Long> ids) {
        try {
            return objectMapper.writeValueAsString(productCommandPort.getByIds(ids));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

 /*   public ProductDto save(Product product) {
        return null;
    }*/
}
