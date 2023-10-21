package com.uc.order.infra.adapters.order.rest;

import com.uc.catalog.domain.product.model.Product;
import com.uc.catalog.domain.product.usecase.CreateProductUseCase;
import com.uc.catalog.infra.adapters.product.mapper.ProductToProductResponseMapper;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.order.domain.order.model.Order;
import com.uc.order.domain.order.usecase.CreateOrderUseCase;
import com.uc.order.domain.order.usecase.DeleteOrderUseCase;
import com.uc.order.domain.order.usecase.UpdateOrderUseCase;
import com.uc.order.infra.adapters.order.mapper.OrderToOrderResponseMapper;
import com.uc.order.infra.adapters.order.rest.request.CreateOrderRequest;
import com.uc.order.infra.adapters.order.rest.request.UpdateOrderRequest;
import com.uc.order.infra.adapters.order.rest.response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final UseCaseHandler<Order, CreateOrderUseCase> createOrderUseCaseHandler;
    private final UseCaseHandler<Order, UpdateOrderUseCase> updateOrderUseCaseHandler;
    private final UseCaseHandler<Order, DeleteOrderUseCase> deleteOrderUseCaseHandler;
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
    public OrderResponse getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @GetMapping("/pageable")
    public Page<OrderResponse> getAll(Pageable pageable){
        return orderService.getAll(pageable);
    }
    @GetMapping()
    public List<OrderResponse> getAll(){
        return orderService.getAll();
    }
}
