package com.TurkcellSRS.BillingAccountService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AccountCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
