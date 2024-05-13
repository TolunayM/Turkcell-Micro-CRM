package com.TurkcellSRS.CustomerService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nationalityId;

    private Long accountNumber;


    private String firstName;


    private String middleName;


    private String lastName;


    private String fatherName;


    private String motherName;

    private Date birthDate;


    private String gender;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
