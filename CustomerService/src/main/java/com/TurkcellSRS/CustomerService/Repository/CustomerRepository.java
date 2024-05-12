package com.TurkcellSRS.CustomerService.Repository;


import com.TurkcellSRS.CustomerService.Entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

//    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse(c.id,c.firstName,c.middleName,c.lastName,c.nationalityId)" +
//            "FROM Customer c " +
//            "WHERE c.nationalityId= :#{#customerRequest.nationalityId}" +
//            " or c.id= :#{#customerRequest.id}" +
//            " or c.firstName= :#{#customerRequest.firstName}" +
//            " or c.middleName= :#{#customerRequest.middleName}" +
//            " or c.lastName= :#{#customerRequest.lastName}")
//    ResponseEntity<List<SearchCustomerResponse>> searchCustomer(Customer customerRequest);


//    List<Customer> findByNationalityIdOrIdOrFirstNameOrMiddleNameOrLastName(Long nationalityId, Long id, String firstName, String middleName, String lastName);


    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse(c.id, c.firstName, c.middleName, c.lastName, c.nationalityId) " +
            "FROM Customer c " +
            "WHERE (c.nationalityId = :nationalityId) " +
            "or (c.id = :id) " +
            "or (c.firstName = :firstName) " +
            "or (c.middleName = :middleName) " +
            "or (c.lastName = :lastName)")
    List<SearchCustomerResponse> findByFilter(Long nationalityId, Long id, String firstName, String middleName, String lastName);
}

