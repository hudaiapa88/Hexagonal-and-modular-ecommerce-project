package com.uc.order.infra.adapters.order.jpa.entity;

import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

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
