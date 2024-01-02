package com.uc.catalog.adapters.product.rest.mapper;

import com.uc.adapters.category.rest.response.CategoryResponse;
import com.uc.catalog.adapters.product.rest.response.ProductResponse;
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
public class ProductToProductResponseMapperImpl implements ProductToProductResponseMapper {

    @Override
    public ProductResponse convert(Product input) {
        if ( input == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( input.getId() );
        productResponse.setTitle( input.getTitle() );
        productResponse.setCategory( categoryToCategoryResponse( input.getCategory() ) );
        productResponse.setPrice( input.getPrice() );

        return productResponse;
    }

    @Override
    public List<ProductResponse> convertList(List<Product> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( inputList.size() );
        for ( Product product : inputList ) {
            list.add( convert( product ) );
        }

        return list;
    }

    protected CategoryResponse categoryToCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( category.getId() );
        categoryResponse.setTitle( category.getTitle() );

        return categoryResponse;
    }
}
