package com.uc.catalog.infra.adapters.product.jpa.repository;

import com.uc.catalog.infra.adapters.product.jpa.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
