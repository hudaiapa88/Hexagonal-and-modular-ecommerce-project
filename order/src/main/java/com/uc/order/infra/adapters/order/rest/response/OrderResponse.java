package com.uc.order.infra.adapters.order.rest.response;

import com.uc.order.infra.adapters.orderLine.rest.response.OrderLineResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderResponse  {
    private BigDecimal totalPrice;
    private List<OrderLineResponse> orderLines;
    private AddressResponse address;
}
