package com.TurkcellSRS.CustomerService.Repository;

import com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.ContactResponse;
import com.TurkcellSRS.CustomerService.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.ContactResponse.ContactResponse(c.email, c.gsmNumber, c.homeNumber, c.fax, c.customer.id) " +
            "FROM Contact c " +
            "WHERE c.customer.id = :customerId")
    ContactResponse findAllByCustomerId(Long customerId);
}
