package com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse;

import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Entity.Contact;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerInfoResponse {
    private Long nationalityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private Date birthDate;
    private String gender;
    //TODO change this to dto
    private AddressResponse defaultAddress;
    private List<AddressResponse> addresses;


}
