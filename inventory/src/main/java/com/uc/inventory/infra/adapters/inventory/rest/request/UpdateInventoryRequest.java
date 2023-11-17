package com.uc.inventory.infra.adapters.inventory.rest.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInventoryRequest {
    private Long id;
    private Long amount;
}
