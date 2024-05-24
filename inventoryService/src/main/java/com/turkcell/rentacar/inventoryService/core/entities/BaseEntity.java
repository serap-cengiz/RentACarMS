package com.turkcell.rentacar.inventoryService.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor //Parametresiz Concturctor
@AllArgsConstructor //Tüm fieldları paremetre olan constructor
@Data //Getter ve setter birlikte
@MappedSuperclass//inharite eden sınıfa özelliklerinide inharite etsin diye
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")//Veritabanında sütünun adının nasıl gözükmesini istiyorsak
    private int id;

    @Column(name="createdDate")
    private LocalDateTime createdDate;

    @Column(name="updateDate")
    private LocalDateTime updateDate;

    @Column(name="deletedDate")
    private LocalDateTime deleteDate;

}
