package com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse;

import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Entity.Contact;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AddAddressResponse {

    private String city;
    private String district;
    private String street;
    private Long houseNumber;
    private String description;
    private Long customerId;
}
