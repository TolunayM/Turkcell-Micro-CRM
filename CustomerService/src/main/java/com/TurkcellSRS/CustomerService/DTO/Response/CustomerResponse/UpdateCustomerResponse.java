package com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse;

import lombok.Data;

@Data
public class UpdateCustomerResponse {

    private String firstName;
    private Long nationalityId;
    private String middleName;
    private String lastName;
    private String motherName;
    private String fatherName;
    private String birthDate;

}
