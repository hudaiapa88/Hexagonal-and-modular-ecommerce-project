package com.uc.category.infra.mapper;

import com.uc.category.domain.model.Category;
import com.uc.category.infra.rest.response.CategoryResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-29T14:02:53+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
@Component
public class CategoryToCategoryResponseMapperImpl implements CategoryToCategoryResponseMapper {

    @Override
    public CategoryResponse convert(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( entity.getId() );
        categoryResponse.setTitle( entity.getTitle() );

        return categoryResponse;
    }

    @Override
    public List<CategoryResponse> convertList(List<Category> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CategoryResponse> list = new ArrayList<CategoryResponse>( entityList.size() );
        for ( Category category : entityList ) {
            list.add( convert( category ) );
        }

        return list;
    }
}
