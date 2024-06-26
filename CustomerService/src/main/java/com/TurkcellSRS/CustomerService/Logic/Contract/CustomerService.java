package com.TurkcellSRS.CustomerService.Logic.Contract;


import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.SearchCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.UpdateCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest);
    ResponseEntity<CustomerInfoResponse> getCustomers(Long id);
    ResponseEntity<List<SearchCustomerResponse>> searchByVariables(Long nationalityId, Long id, String firstName, String middleName, String lastName, Pageable pageable);
    ResponseEntity<UpdateCustomerResponse> updateCustomer(UpdateCustomerRequest updateCustomerRequest);
    ResponseEntity<String> deleteCustomer(Long id);
}
