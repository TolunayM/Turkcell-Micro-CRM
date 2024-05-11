package com.TurkcellSRS.CustomerService.Repository;

import com.TurkcellSRS.CustomerService.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
