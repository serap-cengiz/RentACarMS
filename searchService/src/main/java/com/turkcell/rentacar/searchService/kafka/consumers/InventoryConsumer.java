package com.turkcell.rentacar.searchService.kafka.consumers;

import com.turkcell.rentacar.common.events.InventoryCreatedEvent;
import com.turkcell.rentacar.searchService.business.abstracts.InventoryService;
import com.turkcell.rentacar.searchService.entities.concretes.Inventory;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryConsumer.class);
    private InventoryService inventoryrService;

    @KafkaListener(topics = "inventory-brand-created",groupId = "inventory-create")
    public void consume(InventoryCreatedEvent inventoryCreatedEvent){
        Inventory inventory=new Inventory();
        inventory.setBrandName(inventoryCreatedEvent.getBrandName());
        inventory.setId(inventory.getId());
        this.inventoryrService.add(inventory);
    }

}
