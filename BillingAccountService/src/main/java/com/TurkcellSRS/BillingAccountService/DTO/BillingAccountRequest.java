package com.TurkcellSRS.BillingAccountService.DTO;


import com.TurkcellSRS.BillingAccountService.Entity.AccountCart;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Data
public class BillingAccountRequest {

    private Long customer;
    private Long address;
    private Long accountNumber;
    private String name;
    private String type;
    private String description;
    private Boolean status;




}
