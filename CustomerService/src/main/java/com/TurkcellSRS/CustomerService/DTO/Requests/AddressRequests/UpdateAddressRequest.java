package com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateAddressRequest {

    private Long id;
    @NotBlank(message = "This field is required")
    private String city;

    @NotBlank(message = "This field is required")
    private String district;

    @NotBlank(message = "This field is required")
    private String street;

    @NotBlank(message = "This field is required")
    private Long houseNumber;

    @NotBlank(message = "This field is required")
    private String description;
}
