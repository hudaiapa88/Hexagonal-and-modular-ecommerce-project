package com.uc.order.infra.adapters.orderLine.jpa;

import com.uc.order.domain.order.usecase.GetOrderByOrderIdUseCase;
import com.uc.order.domain.orderline.model.OrderLine;
import com.uc.order.domain.orderline.port.OrderLinePort;
import com.uc.order.domain.orderline.usecase.DeleteOrderLineUseCase;
import com.uc.order.infra.adapters.orderLine.jpa.entity.OrderLineEntity;
import com.uc.order.infra.adapters.orderLine.jpa.repository.OrderLineRepository;
import com.uc.order.infra.adapters.orderLine.jpa.mapper.OrderLineEntityToOrderLineMapper;
import com.uc.order.infra.adapters.orderLine.jpa.mapper.OrderLineToOrderLineEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderLineAdapter implements OrderLinePort {

  private final OrderLineRepository orderLineRepository;;
  private final OrderLineEntityToOrderLineMapper orderLineEntityToOrderLineMapper;
  private final OrderLineToOrderLineEntityMapper orderLineToOrderLineEntityMapper;
    @Override
    public OrderLine save(OrderLine orderLine) {
      OrderLineEntity orderLineEntity = orderLineToOrderLineEntityMapper.convert(orderLine);
        return orderLineEntityToOrderLineMapper.convert(orderLineRepository.save(orderLineEntity));
    }

    @Override
    public List<OrderLine> getByOrderId(GetOrderByOrderIdUseCase value) {
        return orderLineEntityToOrderLineMapper.convertList(findByOrderId(value.getId()));
    }

    private List<OrderLineEntity> findByOrderId(Long id) {
        return orderLineRepository.findByOrder_Id(id);
    }

    @Override
    public void delete(DeleteOrderLineUseCase deleteOrderLineUseCase) {
         orderLineRepository.deleteById(deleteOrderLineUseCase.getId());
    }
}
