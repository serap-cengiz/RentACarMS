package com.turkcell.rentacar.inventoryService.entities;

import com.turkcell.rentacar.inventoryService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data//getter+setter @Getter + @Setter
@Entity //bir veritabanı varlığı olduğunu gösterir
@Table(name="brands")//Tablonun ismide brands olsun
@SequenceGenerator(
        name = "base_sequence_generator",
        sequenceName = "brand_sequence",
        allocationSize = 1
)
public class Brand extends BaseEntity {
    @Column(name="name")
    private String name;

    

}
