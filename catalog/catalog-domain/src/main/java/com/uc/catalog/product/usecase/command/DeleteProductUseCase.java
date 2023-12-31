package com.uc.catalog.product.usecase.command;

import com.uc.catalog.common.usecase.UseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteProductUseCase  implements UseCase {

  private   Long id;
}
