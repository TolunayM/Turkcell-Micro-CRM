package com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse;


import lombok.Data;

@Data
public class UpdateContactResponse {

    private Long id;
    private String email;
    private Long gsmNumber;
    private Long homeNumber;
    private Long fax;
}
