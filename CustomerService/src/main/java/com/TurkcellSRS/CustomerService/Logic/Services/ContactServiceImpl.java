package com.TurkcellSRS.CustomerService.Logic.Services;


import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.AddContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests.UpdateContactRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.AddContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.ContactResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.UpdateContactResponse;
import com.TurkcellSRS.CustomerService.Entity.Contact;
import com.TurkcellSRS.CustomerService.Logic.Contract.ContactService;
import com.TurkcellSRS.CustomerService.Repository.ContactRepository;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;


    public ResponseEntity<AddContactResponse> addContact(AddContactRequest addContactRequest){
        var contact = modelMapper.map(addContactRequest, Contact.class);
        var savedContact = contactRepository.save(contact);
        return ResponseEntity.ok(modelMapper.map(savedContact, AddContactResponse.class));
    }


    public ResponseEntity<UpdateContactResponse> updateContact(Long contactId, UpdateContactRequest updateContactRequest) {
        if(contactRepository.existsById(contactId)){
            var updateContact = modelMapper.map(updateContactRequest, Contact.class);
            var savedContact = contactRepository.save(updateContact);
            return ResponseEntity.ok(modelMapper.map(savedContact, UpdateContactResponse.class));
        }

        return ResponseEntity.ok(modelMapper.map("Contact not found with id: " + updateContactRequest, UpdateContactResponse.class));
    }


    public ResponseEntity<ContactResponse> getContactByCustomer(Long contactId) {
        return ResponseEntity.ok(contactRepository.findAllByCustomerId(contactId));
    }
}
