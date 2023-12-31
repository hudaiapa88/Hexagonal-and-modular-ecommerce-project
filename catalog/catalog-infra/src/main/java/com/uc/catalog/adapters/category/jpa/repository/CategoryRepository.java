package com.uc.catalog.adapters.category.jpa.repository;

import com.uc.catalog.adapters.category.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
