package com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests;

import com.TurkcellSRS.CustomerService.Entity.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddAddressRequest {

    @NotBlank(message = "This field is required")
    private String city;

    @NotBlank(message = "This field is required")
    private String district;

    @NotBlank(message = "This field is required")
    private String street;

    @NotNull(message = "This field is required")
    private Long houseNumber;

    @NotBlank(message = "This field is required")
    private String description;
    private Long customerId;
}
