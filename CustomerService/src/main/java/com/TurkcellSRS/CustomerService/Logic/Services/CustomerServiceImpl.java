package com.TurkcellSRS.CustomerService.Logic.Services;

import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.UpdateCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.*;
import com.TurkcellSRS.CustomerService.Logic.Contract.CustomerService;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.SearchCustomerRequest;
import com.TurkcellSRS.CustomerService.Entity.Customer;
import com.TurkcellSRS.CustomerService.Logic.Rules.CustomerBusinessRules;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final CustomerBusinessRules customerBusinessRules;

    public ResponseEntity<CustomerInfoResponse> getCustomers(Long id) {
        var customer = customerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(modelMapper.map(customer, CustomerInfoResponse.class));
    }
    @Override
    public ResponseEntity<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest) {
        customerBusinessRules.checkCustomerWithSameNationalityIdIsExist(addCustomerRequest.getNationalityId());
        var saveCustomer = modelMapper.map(addCustomerRequest, Customer.class);
        var savedCustomer = customerRepository.save(saveCustomer);
        return ResponseEntity.ok(modelMapper.map(savedCustomer, AddCustomerResponse.class));
    }

    @Override
    public ResponseEntity<SearchCustomerResponse> searchCustomer(SearchCustomerRequest customerRequest) {
//
//        var searchCustomer = modelMapper.map(customerRequest, Customer.class);
//        var customer = customerRepository.searchCustomer(searchCustomer);
//        return ResponseEntity.ok(modelMapper.map(customer, SearchCustomerResponse.class));
        return null;
    }


    public ResponseEntity<List<SearchCustomerResponse>> searchByVariables(Long nationalityId, Long id, String firstName, String middleName, String lastName) {

        customerBusinessRules.checkCustomerIsExist(nationalityId,id, firstName,middleName,lastName);
        return ResponseEntity.ok(customerRepository.findByFilter(nationalityId, id, firstName, middleName, lastName));
    }

    public ResponseEntity<UpdateCustomerResponse> updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        customerBusinessRules.checkCustomerWithSameNationalityIdIsExist(updateCustomerRequest.getNationalityId());
        var customer = modelMapper.map(updateCustomerRequest, Customer.class);
        var updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(modelMapper.map(updatedCustomer, UpdateCustomerResponse.class));
    }

    @Override
    public ResponseEntity<String> deleteCustomer(Long id) {
        //TODO Check if the customer has active order or product ?
        customerBusinessRules.checkCustomerIsExist(id);
        customerRepository.deleteById(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}
