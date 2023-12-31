package com.uc.catalog.adapters.product.jpa.mapper;

import com.uc.catalog.adapters.category.jpa.entity.CategoryEntity;
import com.uc.catalog.adapters.product.jpa.entity.ProductEntity;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.product.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-31T14:16:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ProductToProductEntityMapperImpl implements ProductToProductEntityMapper {

    @Override
    public ProductEntity convert(Product input) {
        if ( input == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( input.getId() );
        productEntity.setTitle( input.getTitle() );
        productEntity.setCategory( categoryToCategoryEntity( input.getCategory() ) );
        productEntity.setPrice( input.getPrice() );

        return productEntity;
    }

    @Override
    public List<ProductEntity> convertList(List<Product> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>( inputList.size() );
        for ( Product product : inputList ) {
            list.add( convert( product ) );
        }

        return list;
    }

    protected CategoryEntity categoryToCategoryEntity(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( category.getId() );
        categoryEntity.setTitle( category.getTitle() );

        return categoryEntity;
    }
}
