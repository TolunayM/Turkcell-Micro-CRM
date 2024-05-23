package com.TurkcellSRS.BillingAccountService.DTO;


import lombok.Data;

@Data
public class BillingAccountResponse {
    private Long customer;
    private Long address;
    private Long accountNumber;
    private String name;
    private String type;
    private String description;
    private Boolean status;
}
