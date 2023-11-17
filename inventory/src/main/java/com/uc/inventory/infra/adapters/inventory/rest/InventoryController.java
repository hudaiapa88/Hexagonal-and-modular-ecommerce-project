package com.uc.inventory.infra.adapters.inventory.rest;


import com.uc.common.usecase.NoUseCaseHandler;
import com.uc.common.usecase.UseCaseHandler;
import com.uc.common.usecase.VoidUseCaseHandler;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.usecase.*;
import com.uc.inventory.infra.adapters.inventory.mapper.InventoryToInventoryResponseMapper;
import com.uc.inventory.infra.adapters.inventory.rest.request.CreateInventoryRequest;
import com.uc.inventory.infra.adapters.inventory.rest.response.InventoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventory")
@RequiredArgsConstructor
@Transactional("inventoryTransactionManager")
public class InventoryController {

    private final UseCaseHandler<Inventory, CreateInventoryUseCase> createInventoryUseCaseHandler;
    private final UseCaseHandler<Inventory, UpdateInventoryUseCase> updateOrderUseCaseHandler;
    private final VoidUseCaseHandler<DeleteInventoryUseCase> deleteInventoryUseCaseHandler;
    private final UseCaseHandler<Inventory, GetInventoryByInventoryIdUseCase> getByInventoryIdUseCaseHandler;

    private final UseCaseHandler<Inventory, GetInventoryByProductIdUseCase> getByProductIdUseCaseHandler;
    private final NoUseCaseHandler<List<Inventory>> getAllUseCase;
    private final InventoryToInventoryResponseMapper inventoryToInventoryResponseMapper;
    @PostMapping
    public InventoryResponse save(@Valid @RequestBody CreateInventoryRequest createOrderRequest){
        return inventoryToInventoryResponseMapper.convert(createInventoryUseCaseHandler.handle(createOrderRequest.toUseCase()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        deleteInventoryUseCaseHandler.handle(new DeleteInventoryUseCase(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InventoryResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(inventoryToInventoryResponseMapper.convert(getByInventoryIdUseCaseHandler.handle(new GetInventoryByInventoryIdUseCase(id))))  ;
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<InventoryResponse> getByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(inventoryToInventoryResponseMapper.convert(getByProductIdUseCaseHandler.handle(new GetInventoryByProductIdUseCase(productId))))  ;
    }

    /* @GetMapping("/pageable")
     public Page<OrderResponse> getAll(Pageable pageable){
         return orderService.getAll(pageable);
     }*/
    @GetMapping()
    public ResponseEntity<List<InventoryResponse>> getAll(){
        return ResponseEntity.ok(inventoryToInventoryResponseMapper.convertList(getAllUseCase.handle())) ;
    }
}
