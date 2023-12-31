package com.uc.order.adapters.order.rest;



import com.uc.order.adapters.order.rest.mapper.OrderToOrderResponseMapper;
import com.uc.order.adapters.order.rest.request.CreateOrderRequest;
import com.uc.order.adapters.order.rest.request.UpdateOrderRequest;
import com.uc.order.adapters.order.rest.response.OrderResponse;
import com.uc.order.common.usecase.NoUseCaseHandler;
import com.uc.order.common.usecase.UseCaseHandler;
import com.uc.order.common.usecase.VoidUseCaseHandler;
import com.uc.order.order.model.Order;
import com.uc.order.order.usecase.CreateOrderUseCase;
import com.uc.order.order.usecase.DeleteOrderUseCase;
import com.uc.order.order.usecase.GetOrderByOrderIdUseCase;
import com.uc.order.order.usecase.UpdateOrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
@Transactional("orderTransactionManager")
public class OrderController {

    private final UseCaseHandler<Order, CreateOrderUseCase> createOrderUseCaseHandler;
    private final UseCaseHandler<Order, UpdateOrderUseCase> updateOrderUseCaseHandler;
    private final VoidUseCaseHandler<DeleteOrderUseCase> deleteOrderUseCaseHandler;
    private final UseCaseHandler<Order, GetOrderByOrderIdUseCase> getByOrderIdUseCaseHandler;
    private final NoUseCaseHandler<List<Order>> getAllUseCase;
    private final OrderToOrderResponseMapper orderToOrderResponseMapper;
    @PostMapping
    public OrderResponse save(@Valid @RequestBody CreateOrderRequest createOrderRequest){
        return orderToOrderResponseMapper.convert(createOrderUseCaseHandler.handle(createOrderRequest.toUseCase()));
    }

    @PutMapping("/{id}")
    public OrderResponse update(@PathVariable Long id,@RequestBody UpdateOrderRequest updateOrderRequest){
        return orderToOrderResponseMapper.convert(updateOrderUseCaseHandler.handle(updateOrderRequest.toUseCase(id))) ;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         deleteOrderUseCaseHandler.handle(new DeleteOrderUseCase(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderToOrderResponseMapper.convert(getByOrderIdUseCaseHandler.handle(new GetOrderByOrderIdUseCase(id))))  ;
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> getAll(){
        return ResponseEntity.ok(orderToOrderResponseMapper.convertList(getAllUseCase.handle())) ;
    }
}
