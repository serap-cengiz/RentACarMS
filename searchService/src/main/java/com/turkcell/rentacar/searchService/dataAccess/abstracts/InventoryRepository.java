package com.turkcell.rentacar.searchService.dataAccess.abstracts;

import com.turkcell.rentacar.searchService.entities.concretes.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Inventory,Integer> {

}
