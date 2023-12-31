package com.uc.order.adapters.order.jpa;


import com.uc.order.adapters.order.jpa.entity.OrderEntity;
import com.uc.order.adapters.order.jpa.mapper.OrderEntityToOrderMapper;
import com.uc.order.adapters.order.jpa.mapper.OrderToOrderEntityMapper;
import com.uc.order.adapters.order.jpa.repository.OrderRepository;
import com.uc.order.common.exception.EntityNotFoundException;
import com.uc.order.order.model.Order;
import com.uc.order.order.port.OrderPort;
import com.uc.order.order.usecase.DeleteOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderAdapter implements OrderPort {

   private final OrderRepository orderRepository;
   private final OrderEntityToOrderMapper orderEntityToOrderMapper;
   private final OrderToOrderEntityMapper orderToOrderEntityMapper;
    @Override
    public Order save(Order order) {
        OrderEntity orderEntity=orderToOrderEntityMapper.convert(order);
        return orderEntityToOrderMapper.convert(orderRepository.save(orderEntity));
    }

    @Override
    public Order getByOrderId(Long id) {
        return orderEntityToOrderMapper.convert(findById(id));
    }

    private OrderEntity findById(Long id) {
    return orderRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Sipariş bulunamadı."));
    }

    @Override
    public void delete(DeleteOrderUseCase deleteOrderUseCase) {
       orderRepository.deleteById(deleteOrderUseCase.getId());
    }

    @Override
    public List<Order> getAll() {
        return orderEntityToOrderMapper.convertList(orderRepository.findAll());
    }
}
