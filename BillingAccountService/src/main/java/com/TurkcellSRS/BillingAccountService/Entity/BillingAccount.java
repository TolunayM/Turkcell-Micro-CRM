package com.TurkcellSRS.BillingAccountService.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private Long customer;
    private Long address;
    private Long serviceAddress;
    private String name;
    private String type;
    private String description;
    private Boolean status;
    
    @OneToMany
    private Set<AccountCart> accountCarts;
}
