package com.uc.catalog.api.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uc.catalog.domain.product.port.ProductPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductApi {
    private final ProductPort productPort;
    private final ObjectMapper objectMapper;

    public String getById(Long id)  {
        try {
            return objectMapper.writeValueAsString(productPort.getById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getByIds(List<Long> ids) {
        try {
            return objectMapper.writeValueAsString(productPort.getByIds(ids));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

 /*   public ProductDto save(Product product) {
        return null;
    }*/
}
