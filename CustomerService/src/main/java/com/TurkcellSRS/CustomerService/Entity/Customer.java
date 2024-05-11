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

    @Digits(integer = 11, fraction = 0) @Positive
    private Long nationalityId;
    @Positive
    private Long accountNumber;

    @NotBlank(message = "This field is required") @Size(max = 50)
    private String firstName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String middleName;

    @NotBlank(message = "This field is required") @Size(max = 50)  @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String lastName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String fatherName;

    @Size(max = 50) @Pattern(regexp = "^[a-zA-Z0-9_]*[a-zA-Z_]*[a-zA-Z0-9_]*$")
    private String motherName;

    private Date birthDate;

    @NotBlank(message = "This field is required")
    private String gender;

    @OneToMany
    @JoinColumn(name = "address_id")
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
