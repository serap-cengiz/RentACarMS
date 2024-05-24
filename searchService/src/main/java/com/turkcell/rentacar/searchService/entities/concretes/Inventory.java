package com.turkcell.rentacar.searchService.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="inventory")
public class Inventory {
    @Id
    private int id;
    @Field(name="brandName")
    private String brandName;
}
