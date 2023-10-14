package com.uc.catalog.infra.adapters.product.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper <Input, Out>{

    @Named("convert")
    Out convert(Input entity);

    @IterableMapping(qualifiedByName = "convert")
    List<Out> convertList(List<Input> entityList);



}
