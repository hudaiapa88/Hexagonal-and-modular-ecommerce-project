package com.uc.inventory.inventory.event;

import com.uc.inventory.common.event.Event;
import com.uc.inventory.inventory.usecase.IncreaseInventoryUseCase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncreaseInventoryEvent implements Event {

    private Long id;
    private Long amount;

    public IncreaseInventoryUseCase toModel() {
        IncreaseInventoryUseCase increaseInventoryUseCase=new IncreaseInventoryUseCase();
        increaseInventoryUseCase.setId(id);
        increaseInventoryUseCase.setAmount(amount);
        return increaseInventoryUseCase;
    }


}
