package com.TurkcellSRS.CustomerService.Logic.Contract;


import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.SearchCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.AddCustomerResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.CustomerInfoResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest);
    ResponseEntity<SearchCustomerResponse> searchCustomer(SearchCustomerRequest customerRequest);

    ResponseEntity<CustomerInfoResponse> getCustomers(Long id);
}
