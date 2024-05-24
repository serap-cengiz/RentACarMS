package com.turkcell.rentacar.inventoryService.business.rules;

import com.turkcell.rentacar.inventoryService.business.messages.Messages;
import com.turkcell.rentacar.inventoryService.core.business.abstracts.MessageService;
import com.turkcell.rentacar.inventoryService.core.crossCuttingConcerns.exceptions.types.BusinessException;
import com.turkcell.rentacar.inventoryService.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;
    MessageService messageService;
    public void brandNameCanNotBeDuplicated(String brandName){
        Optional<Brand> brand=brandRepository.findByNameIgnoreCase(brandName);//Optional null değere izin verdiğini söylüyor
        if(brand.isPresent()){//varsa
            throw new BusinessException(messageService.getMessage(Messages.BrandErrors.BrandNameExists));
        }
    }
    public void brandMustExists(int brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (!brand.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.BrandErrors.BrandNotExists));
        }
    }
}
