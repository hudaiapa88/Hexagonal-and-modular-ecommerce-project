package com.uc.catalog.adapters.category.jpa.mapper;

import com.uc.catalog.adapters.category.jpa.entity.CategoryEntity;
import com.uc.catalog.category.model.Category;
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
public class CategoryEntityToCategoryMapperImpl implements CategoryEntityToCategoryMapper {

    @Override
    public Category convert(CategoryEntity input) {
        if ( input == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( input.getId() );
        category.setTitle( input.getTitle() );

        return category;
    }

    @Override
    public List<Category> convertList(List<CategoryEntity> inputList) {
        if ( inputList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( inputList.size() );
        for ( CategoryEntity categoryEntity : inputList ) {
            list.add( convert( categoryEntity ) );
        }

        return list;
    }
}
