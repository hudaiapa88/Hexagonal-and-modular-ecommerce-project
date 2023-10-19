package com.uc.order.domain.orderline.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderLine {
    private Long id;
    private List<Long> productIds= new ArrayList<>();
}
