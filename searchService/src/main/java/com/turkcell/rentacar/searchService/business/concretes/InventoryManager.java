package com.turkcell.rentacar.searchService.business.concretes;

import com.turkcell.rentacar.searchService.business.abstracts.InventoryService;
import com.turkcell.rentacar.searchService.dataAccess.abstracts.InventoryRepository;
import com.turkcell.rentacar.searchService.entities.concretes.Inventory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryManager implements InventoryService {

    private InventoryRepository inventoryRepository;
    @Override
    public void add(Inventory inventory) {
        this.inventoryRepository.save(inventory);

    }
}
