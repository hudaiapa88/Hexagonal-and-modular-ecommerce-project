package com.uc.domain.order.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
public class Order {
    private Long id;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
  //  private List<Product> products= new ArrayList<>();
    private BigDecimal totalPrice;
}
