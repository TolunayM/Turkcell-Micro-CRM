package com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse;

import lombok.Data;

import java.util.Date;

@Data
public class AddCustomerResponse {
    private Long NationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String motherName;
    private String fatherName;
}
