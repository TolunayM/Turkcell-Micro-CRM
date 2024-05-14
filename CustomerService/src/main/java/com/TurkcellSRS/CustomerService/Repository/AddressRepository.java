package com.TurkcellSRS.CustomerService.Repository;

import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse(a.city, a.district, a.street, a.houseNumber, a.description,a.customer.id) " +
            "FROM Address a " +
            "WHERE a.customer.id = :customerId")
    List<AddressResponse> findAllByCustomerId(Long customerId);
}
