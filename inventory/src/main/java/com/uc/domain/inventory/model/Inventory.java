package com.uc.domain.inventory.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Inventory {
    private Long id;
    private Long productId;
    private Long amount;
}