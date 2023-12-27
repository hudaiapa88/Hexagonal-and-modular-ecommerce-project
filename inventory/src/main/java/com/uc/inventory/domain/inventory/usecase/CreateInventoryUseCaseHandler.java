package com.uc.inventory.domain.inventory.usecase;

import  com.uc.inventory.domain.common.DomainComponent;
import  com.uc.inventory.domain.common.usecase.UseCaseHandler;;
import com.uc.inventory.domain.catalog.model.Product;
import com.uc.inventory.domain.catalog.port.ProductPort;
import com.uc.inventory.domain.inventory.model.Inventory;
import com.uc.inventory.domain.inventory.port.InventoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class CreateInventoryUseCaseHandler implements UseCaseHandler<Inventory, CreateInventoryUseCase> {

    private final ProductPort productPort;
    private final InventoryPort inventoryPort;

    @Override
    public Inventory handle(CreateInventoryUseCase value) {
        Inventory inventory = new Inventory();
        Product product= productPort.getByProductId(value.getProductId());
        inventory.setProductId(product.getId());
        inventory.setAmount(value.getAmount());
        return inventoryPort.save(inventory);
    }
}
