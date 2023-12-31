package com.uc.catalog.adapters.category.rest.request;

import com.uc.catalog.category.usecase.UpdateCategoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequest {
       private String title;
      public UpdateCategoryUseCase toUseCase(Long id){
           UpdateCategoryUseCase updateCategoryUseCase= new UpdateCategoryUseCase();
           updateCategoryUseCase.setId(id);
           updateCategoryUseCase.setTitle(title);
           return updateCategoryUseCase;
       }
}
