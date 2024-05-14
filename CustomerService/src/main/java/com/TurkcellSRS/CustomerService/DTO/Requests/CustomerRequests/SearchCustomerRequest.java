package com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SearchCustomerRequest {

    private Long id;
    private Long nationalityId;
    private Long accountNumber;
    private String firstName;
    private String middleName;
    private String lastName;

}
