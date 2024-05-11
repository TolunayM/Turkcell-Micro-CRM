package com.TurkcellSRS.CustomerService.Logic.Services;

import com.TurkcellSRS.CustomerService.Logic.Contract.CustomerService;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.SearchCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.AddCustomerResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.CustomerInfoResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse;
import com.TurkcellSRS.CustomerService.Entity.Customer;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
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


    public ResponseEntity<CustomerInfoResponse> getCustomers(Long id) {
        var customer = customerRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(modelMapper.map(customer, CustomerInfoResponse.class));
    }
    @Override
    public ResponseEntity<AddCustomerResponse> addCustomer(AddCustomerRequest addCustomerRequest) {
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
        List<Customer> customers = customerRepository.findByNationalityIdOrIdOrFirstNameOrMiddleNameOrLastName(nationalityId, id, firstName, middleName, lastName);
        System.out.println(customers);
        List<SearchCustomerResponse> responses = customers.stream()
                .map(customer -> modelMapper.map(customer, SearchCustomerResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

}
