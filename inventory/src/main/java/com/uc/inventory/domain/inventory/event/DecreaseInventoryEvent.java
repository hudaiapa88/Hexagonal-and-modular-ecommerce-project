package com.uc.inventory.domain.inventory.event;

import com.uc.inventory.domain.common.event.Event;
import com.uc.inventory.domain.inventory.usecase.DecreaseInventoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DecreaseInventoryEvent implements Event {
    private Long productId;
    private Long amount;
    public DecreaseInventoryUseCase toModel() {
        DecreaseInventoryUseCase decreaseInventoryUseCase=new DecreaseInventoryUseCase();
        decreaseInventoryUseCase.setProductId(productId);
        decreaseInventoryUseCase.setAmount(amount);
        return decreaseInventoryUseCase;
    }
}
