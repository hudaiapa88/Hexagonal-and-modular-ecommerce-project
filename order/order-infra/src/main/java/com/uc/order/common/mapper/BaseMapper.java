package com.uc.order.common.mapper;

import com.uc.order.common.page.PageData;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<Input, Out>{

    @Named("convert")
    Out convert(Input input);

    @IterableMapping(qualifiedByName = "convert")
    List<Out> convertList(List<Input> inputList);

    default PageData<Out> convertPage(PageData<Input> pageData) {
        return new PageData<Out>(pageData.getTotalElements(),
                pageData.getTotalPages(),
                pageData.getCurrentPage(),
                pageData.getCurrentPageElements(),
                convertList(pageData.getData()));

    }

}
