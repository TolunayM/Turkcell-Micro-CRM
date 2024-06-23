package com.TurkcellSRS.CustomerService.Controller;

import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.AddContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.UpdateContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.AddContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.ContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.UpdateContactResponse;
import com.TurkcellSRS.CustomerService.Logic.Contract.ContactService;
import com.TurkcellSRS.CustomerService.Logic.Services.ContactServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;



    @GetMapping("/costumers/{costumerId}")
        public ResponseEntity<ContactResponse> getContactByCustomer(@PathVariable Long costumerId){
        return contactService.getContactByCustomer(costumerId);
    }

    @PutMapping
    public ResponseEntity<UpdateContactResponse> updateContact(@Valid @RequestBody Long contactId, UpdateContactRequest updateContactRequest){
        return contactService.updateContact(contactId,updateContactRequest);
    }

    @PostMapping
    public ResponseEntity<AddContactResponse> addContact(@Valid @RequestBody AddContactRequest addContactRequest){
        return contactService.addContact(addContactRequest);
    }
}
