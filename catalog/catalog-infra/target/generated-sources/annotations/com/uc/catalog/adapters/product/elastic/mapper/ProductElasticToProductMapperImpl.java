package com.uc.catalog.adapters.product.elastic.mapper;

import com.uc.catalog.adapters.category.elastic.model.CategoryElastic;
import com.uc.catalog.adapters.product.elastic.model.ProductElastic;
import com.uc.catalog.category.model.Category;
import com.uc.catalog.product.model.Product;
import java.math.BigDecimal;
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
public class ProductElasticToProductMapperImpl implements ProductElasticToProductMapper {

    @Override
    public Product convert(ProductElastic input) {
        if ( input == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( input.getId() );
        product.setTitle( input.getTitle() );
        product.setCategory( categoryElasticToCategory( input.getCategory() ) );
        if ( input.getPrice() != null ) {
            product.setPrice( BigDecimal.valueOf( input.getPrice() ) );
        }

        return product;
    }

    @Override
    public List<Product> convertList(List<ProductElastic> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( inputList.size() );
        for ( ProductElastic productElastic : inputList ) {
            list.add( convert( productElastic ) );
        }

        return list;
    }

    protected Category categoryElasticToCategory(CategoryElastic categoryElastic) {
        if ( categoryElastic == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryElastic.getId() );
        category.setTitle( categoryElastic.getTitle() );

        return category;
    }
}
