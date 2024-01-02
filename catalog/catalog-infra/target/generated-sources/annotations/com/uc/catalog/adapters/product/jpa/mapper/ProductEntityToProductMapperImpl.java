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
    date = "2023-12-31T14:41:03+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class ProductEntityToProductMapperImpl implements ProductEntityToProductMapper {

    @Override
    public Product convert(ProductEntity input) {
        if ( input == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( input.getId() );
        product.setTitle( input.getTitle() );
        product.setCategory( categoryEntityToCategory( input.getCategory() ) );
        product.setPrice( input.getPrice() );

        return product;
    }

    @Override
    public List<Product> convertList(List<ProductEntity> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( inputList.size() );
        for ( ProductEntity productEntity : inputList ) {
            list.add( convert( productEntity ) );
        }

        return list;
    }

    protected Category categoryEntityToCategory(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryEntity.getId() );
        category.setTitle( categoryEntity.getTitle() );

        return category;
    }
}
