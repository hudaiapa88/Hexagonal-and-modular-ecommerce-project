package com.uc.category.infra.mapper;

import com.uc.category.domain.model.Category;
import com.uc.category.infra.jpa.entity.CategoryEntity;
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
public class CategoryEntityToCategoryMapperImpl implements CategoryEntityToCategoryMapper {

    @Override
    public Category convert(CategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( entity.getId() );
        category.setTitle( entity.getTitle() );

        return category;
    }

    @Override
    public List<Category> convertList(List<CategoryEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( entityList.size() );
        for ( CategoryEntity categoryEntity : entityList ) {
            list.add( convert( categoryEntity ) );
        }

        return list;
    }
}
