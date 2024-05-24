package com.turkcell.rentacar.inventoryService.business.concretes;

import com.turkcell.rentacar.common.events.InventoryCreatedEvent;
import com.turkcell.rentacar.inventoryService.business.abstracts.BrandService;
import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.Brands.CreatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.Brands.GetAllBrandResponse;
import com.turkcell.rentacar.inventoryService.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.inventoryService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.inventoryService.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.inventoryService.entities.Brand;
import com.turkcell.rentacar.inventoryService.kafka.producers.InventoryProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesenesidir,ıocden bul newleri getir kullan
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;//enjekte etmek
    private BrandBusinessRules brandBusinessRules;
    private InventoryProducer inventoryProducer;
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createdBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createdBrandRequest.getName());

        Brand brand=this.modelMapperService.forRequest().map(createdBrandRequest,Brand.class);//jpa anlasın diye brand tipine çeviriyoruz
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand=brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse=
                this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);

        InventoryCreatedEvent inventoryCreatedEvent=new InventoryCreatedEvent(createdBrandResponse.getId(),createdBrandResponse.getName());
        inventoryProducer.sendMessage(inventoryCreatedEvent);
        return createdBrandResponse;
    }


    public List<GetAllBrandResponse> getAll() {

        List<Brand> brands=brandRepository.findAll();
        List<GetAllBrandResponse> brandResponses=brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandResponse.class))
                .collect(Collectors.toList());

        return brandResponses;
    }
}
