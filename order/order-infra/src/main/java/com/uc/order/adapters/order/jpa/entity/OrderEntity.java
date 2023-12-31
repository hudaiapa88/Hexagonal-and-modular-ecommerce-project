package com.uc.order.adapters.order.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Entity
@Getter
@Setter
@Table(name = "\"order\"")
public class OrderEntity {
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
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    @Embedded
    private AddressEntity address;

    private BigDecimal totalPrice;
    @PrePersist
    protected void onCreate() {
        updatedDateTime = createdDateTime = LocalDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDateTime = LocalDateTime.now(ZoneOffset.UTC);
    }

}
