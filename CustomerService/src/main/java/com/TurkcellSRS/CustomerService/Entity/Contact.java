package com.TurkcellSRS.CustomerService.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Long gsmNumber;
    private Long homeNumber;
    private Long fax;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
