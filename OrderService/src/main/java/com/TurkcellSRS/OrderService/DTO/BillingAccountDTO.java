package com.TurkcellSRS.OrderService.DTO;


import lombok.Data;

@Data
public class BillingAccountDTO {

    private Long customer;
    private Long address;
    private Long accountNumber;
    private String name;
    private String type;
    private String description;
    private Boolean status;
    private Long cartId;
}
