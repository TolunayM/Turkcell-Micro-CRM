package com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String city;
    private String district;
    private String street;
    private Long houseNumber;
    private String description;
    private Long customerId;
}
