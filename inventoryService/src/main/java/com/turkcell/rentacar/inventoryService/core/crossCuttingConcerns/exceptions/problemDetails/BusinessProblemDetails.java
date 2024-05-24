package com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(){
        setTitle("Business Rule Violation");
        setType("http://turkcell.com/exceptions/business");
        setStatus("400");
    }
}
