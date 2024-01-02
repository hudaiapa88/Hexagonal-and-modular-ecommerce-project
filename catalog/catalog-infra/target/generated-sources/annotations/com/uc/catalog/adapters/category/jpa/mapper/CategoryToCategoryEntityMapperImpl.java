package com.uc.catalog.adapters.category.jpa.mapper;

import com.uc.catalog.adapters.category.jpa.entity.CategoryEntity;
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
public class CategoryToCategoryEntityMapperImpl implements CategoryToCategoryEntityMapper {

    @Override
    public CategoryEntity convert(Category input) {
        if ( input == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( input.getId() );
        categoryEntity.setTitle( input.getTitle() );

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> convertList(List<Category> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<CategoryEntity> list = new ArrayList<CategoryEntity>( inputList.size() );
        for ( Category category : inputList ) {
            list.add( convert( category ) );
        }

        return list;
    }
}
