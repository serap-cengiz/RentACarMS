package com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.handlers;

import com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.problemDetails.BusinessProblemDetails;
import com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.problemDetails.ValidationProblemDetails;
import com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice//exception sınıfı olduğunu belirtir try gibi düşün
public class GlobalExceptionHandler {
    @ExceptionHandler({ MethodArgumentNotValidException.class })//catch gibi düşün
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        Map<String,String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().stream().map(error ->
                validationErrors.put(error.getField(),error.getDefaultMessage())//arayden çekip tek tek alıyor
        ).toList();
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(exception.getMessage());
        return businessProblemDetails;
    }
}
