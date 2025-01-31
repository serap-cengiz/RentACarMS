package com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.problemDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProblemDetails {
    //rfce standarts
    private String title;
    private String detail;
    private String status;
    private String type;
}
