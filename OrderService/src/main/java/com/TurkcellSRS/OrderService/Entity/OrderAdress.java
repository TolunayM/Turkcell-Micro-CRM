package com.TurkcellSRS.OrderService.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrderAdress {

    @Id
    private Long id;
    private String city;
    private String district;
    private String street;
    private Long houseNumber;
    private String description;
}
