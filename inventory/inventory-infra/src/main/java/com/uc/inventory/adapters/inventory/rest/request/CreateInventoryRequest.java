package com.uc.inventory.adapters.inventory.rest.request;

import com.uc.inventory.inventory.usecase.CreateInventoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryRequest {
    private Long productId;
    private Long amount;

    public CreateInventoryUseCase toUseCase() {
        CreateInventoryUseCase createInventoryUseCase= new CreateInventoryUseCase();
        createInventoryUseCase.setAmount(amount);
        createInventoryUseCase.setProductId(productId);
        return createInventoryUseCase;
    }
}
