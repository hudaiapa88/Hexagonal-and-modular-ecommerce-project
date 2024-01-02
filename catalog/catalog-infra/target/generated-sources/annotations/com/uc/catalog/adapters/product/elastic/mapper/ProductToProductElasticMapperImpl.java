package com.uc.catalog.adapters.product.elastic.mapper;

import com.uc.catalog.adapters.category.elastic.model.CategoryElastic;
import com.uc.catalog.adapters.product.elastic.model.ProductElastic;
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
public class ProductToProductElasticMapperImpl implements ProductToProductElasticMapper {

    @Override
    public ProductElastic convert(Product input) {
        if ( input == null ) {
            return null;
        }

        ProductElastic productElastic = new ProductElastic();

        productElastic.setId( input.getId() );
        productElastic.setTitle( input.getTitle() );
        productElastic.setCategory( categoryToCategoryElastic( input.getCategory() ) );
        if ( input.getPrice() != null ) {
            productElastic.setPrice( input.getPrice().doubleValue() );
        }

        return productElastic;
    }

    @Override
    public List<ProductElastic> convertList(List<Product> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<ProductElastic> list = new ArrayList<ProductElastic>( inputList.size() );
        for ( Product product : inputList ) {
            list.add( convert( product ) );
        }

        return list;
    }

    protected CategoryElastic categoryToCategoryElastic(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryElastic categoryElastic = new CategoryElastic();

        categoryElastic.setId( category.getId() );
        categoryElastic.setTitle( category.getTitle() );

        return categoryElastic;
    }
}
