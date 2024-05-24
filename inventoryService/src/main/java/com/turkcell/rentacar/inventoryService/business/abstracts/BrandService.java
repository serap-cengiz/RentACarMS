package com.turkcell.rentacar.inventoryService.business.abstracts;

import com.turkcell.rentacar.inventoryService.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.Brands.CreatedBrandResponse;
import com.turkcell.rentacar.inventoryService.business.dtos.responses.Brands.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest createdBrandRequest);
    List<GetAllBrandResponse> getAll();
}
