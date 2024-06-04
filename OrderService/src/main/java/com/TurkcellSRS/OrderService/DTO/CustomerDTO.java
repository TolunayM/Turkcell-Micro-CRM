package com.TurkcellSRS.OrderService.DTO;


import com.TurkcellSRS.OrderService.Entity.OrderAdress;
import lombok.Data;

@Data
public class CustomerDTO {
    private OrderAdress defaultAddress;
}
