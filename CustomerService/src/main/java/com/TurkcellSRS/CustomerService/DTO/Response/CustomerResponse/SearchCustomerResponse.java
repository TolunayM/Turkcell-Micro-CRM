package com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCustomerResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Long nationalityId;




}
