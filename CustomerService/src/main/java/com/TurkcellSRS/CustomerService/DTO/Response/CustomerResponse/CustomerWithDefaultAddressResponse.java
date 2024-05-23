package com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse;

import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerWithDefaultAddressResponse {
    private Long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private Date birthDate;
    private String gender;
    private List<AddressResponse> addresses;
}
