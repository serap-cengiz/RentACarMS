package com.turkcell.rentacar.inventoryService.business.dtos.responses.Brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedBrandResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;

}
