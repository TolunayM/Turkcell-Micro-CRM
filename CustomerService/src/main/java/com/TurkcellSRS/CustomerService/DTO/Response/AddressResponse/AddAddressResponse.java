package com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse;

import lombok.Data;

@Data
public class AddAddressResponse {

    private String city;
    private String district;
    private String street;
    private Long houseNumber;
    private String description;
    private Long customerId;
}
