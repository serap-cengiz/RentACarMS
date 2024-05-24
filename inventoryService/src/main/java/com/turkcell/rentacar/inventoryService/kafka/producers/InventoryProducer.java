package com.turkcell.rentacar.inventoryService.kafka.producers;

import com.turkcell.rentacar.common.events.InventoryCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class InventoryProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryProducer.class);
    private final KafkaTemplate<String,Object> kafkaTemplate;//key-value
    public InventoryProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(InventoryCreatedEvent inventoryCreatedEvent){
        LOGGER.info(String.format("Inventory added =>%s",inventoryCreatedEvent.toString()));
        Message<InventoryCreatedEvent> message = MessageBuilder.withPayload(inventoryCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC,"inventory-brand-created")
                .build();
        kafkaTemplate.send(message);
    }

}