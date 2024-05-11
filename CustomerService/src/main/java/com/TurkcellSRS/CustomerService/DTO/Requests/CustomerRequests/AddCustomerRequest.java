package com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests;


import lombok.Data;

import java.util.Date;

@Data
public class AddCustomerRequest {
    private Long NationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;
    private String gender;
    private String motherName;
    private String fatherName;
}
