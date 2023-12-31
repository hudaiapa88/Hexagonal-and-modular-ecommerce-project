package com.uc.inventory.adapters.inventory.rest.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryResponse {
    private Long id;
    private Long productId;
    private Long amount;
}
