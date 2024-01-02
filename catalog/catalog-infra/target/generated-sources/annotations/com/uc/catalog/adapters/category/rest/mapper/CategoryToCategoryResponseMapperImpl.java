package com.uc.catalog.adapters.category.rest.mapper;

import com.uc.adapters.category.rest.response.CategoryResponse;
import com.uc.catalog.category.model.Category;
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
public class CategoryToCategoryResponseMapperImpl implements CategoryToCategoryResponseMapper {

    @Override
    public CategoryResponse convert(Category input) {
        if ( input == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( input.getId() );
        categoryResponse.setTitle( input.getTitle() );

        return categoryResponse;
    }

    @Override
    public List<CategoryResponse> convertList(List<Category> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( inputList.size() );
        for ( Category category : inputList ) {
            list.add( convert( category ) );
        }

        return list;
    }
}
