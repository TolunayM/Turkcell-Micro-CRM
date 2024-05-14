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

    @NotBlank(message = "This field is required")
    @Email
    private String email;

    @NotBlank(message = "This field is required")
    @Digits(integer = 11, fraction = 0)
    @Positive
    private Long gsmNumber;

    @Digits(integer = 11, fraction = 0)
    @Positive
    private Long homeNumber;

    @Digits(integer = 12, fraction = 0)
    @Positive
    private Long fax;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
