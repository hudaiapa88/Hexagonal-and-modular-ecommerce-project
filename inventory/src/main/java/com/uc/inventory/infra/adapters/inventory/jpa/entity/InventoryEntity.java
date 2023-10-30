package com.uc.inventory.infra.adapters.inventory.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "generator_sequence"
    )
    @SequenceGenerator(
            name = "generator_sequence",
            allocationSize = 1
    )
    private Long id;
    private Long productId;
    private Long quantity;


}
