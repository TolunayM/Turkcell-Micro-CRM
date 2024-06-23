package com.TurkcellSRS.CustomerService.Repository;


import com.TurkcellSRS.CustomerService.Entity.Customer;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse(c.id, c.firstName, c.middleName, c.lastName, c.nationalityId) " +
            "FROM Customer c " +
            "WHERE (c.nationalityId = :nationalityId) " +
            "or (c.id = :id) " +
            "or (c.firstName LIKE %:firstName%) " +
            "or (c.middleName = :middleName) " +
            "or (c.lastName LIKE %:lastName%)")
    List<SearchCustomerResponse> findByFilter(Long nationalityId, Long id, String firstName, String middleName, String lastName , Pageable pageable);


    @Query("SELECT new com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse(c.id, c.firstName, c.middleName, c.lastName, c.nationalityId) " +
            "FROM Customer c " +
            "WHERE (c.nationalityId = :nationalityId)")
    SearchCustomerResponse existByNationalityId(Long nationalityId);
}

