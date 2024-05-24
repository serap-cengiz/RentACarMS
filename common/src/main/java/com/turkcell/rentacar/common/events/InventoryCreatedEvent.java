package com.turkcell.rentacar.common.events;

public class InventoryCreatedEvent {
    private int id;
    private String brandName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public InventoryCreatedEvent(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public InventoryCreatedEvent() {
    }
}
