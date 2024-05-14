package com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateAddressResponse {

    private String city;
    private String district;
    private String street;
    private Long houseNumber;
    private String description;

}
