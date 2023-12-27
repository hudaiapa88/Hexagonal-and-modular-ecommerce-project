package com.uc.inventory.domain.inventory.event;

import com.uc.inventory.domain.common.event.Event;
import com.uc.inventory.domain.inventory.usecase.IncreaseInventoryUseCase;
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
