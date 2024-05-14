package com.TurkcellSRS.CustomerService.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
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


    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @JsonManagedReference
    @OneToOne(mappedBy = "customer")
    private Contact contact;
}
