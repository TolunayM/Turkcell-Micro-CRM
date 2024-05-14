package com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {
    private String email;
    private Long gsmNumber;
    private Long homeNumber;
    private Long fax;
    private Long customerId;
}
