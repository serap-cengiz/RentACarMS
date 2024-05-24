package com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.problemDetails;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails{
    public ValidationProblemDetails(){
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setType("http://turkcell.com/exceptions/validation");
        setStatus("400");
    }
    private Map<String,String> errors;
}
