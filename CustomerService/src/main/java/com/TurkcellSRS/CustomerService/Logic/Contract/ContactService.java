package com.TurkcellSRS.CustomerService.Logic.Contract;

import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.AddContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.ContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.UpdateContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.AddContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.ContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.UpdateContactResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {

    ResponseEntity<AddContactResponse> addContact(AddContactRequest addContactRequest);
    ResponseEntity<UpdateContactResponse> updateContact(Long contactId, UpdateContactRequest updateContactRequest);

    ResponseEntity<ContactResponse> getContactByCustomer(Long contactId);
}
