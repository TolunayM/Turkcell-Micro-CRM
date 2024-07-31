package com.TurkcellSRS.CustomerService.Services;

import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.AddCustomerResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.CustomerInfoResponse;
import com.TurkcellSRS.CustomerService.Entity.Customer;
import com.TurkcellSRS.CustomerService.Logic.Rules.CustomerBusinessRules;
import com.TurkcellSRS.CustomerService.Logic.Services.CustomerServiceImpl;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {


    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerBusinessRules customerBusinessRules;

    @BeforeEach
    void setUp(){
        modelMapper = mock(ModelMapper.class);
        customerRepository = mock(CustomerRepository.class);
        customerBusinessRules = mock(CustomerBusinessRules.class);
        customerServiceImpl = new CustomerServiceImpl(modelMapper, customerRepository, customerBusinessRules);
    }

    @Test
//    @ValueSource(longs = {1, 2, 3,4,5,6,7,8,9,10})
    void getCustomers(){

        //setting up the customer object and requested fields
        Long id = 1L;
        Customer customer = new Customer();
        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();
        customer.setId(id);
        customer.setFirstName("Spongebob");
        customerInfoResponse.setFirstName("Spongebob");

        // db call to get the customer by id WHEN customer is found THEN return the customer
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
        when(modelMapper.map(customer, CustomerInfoResponse.class)).thenReturn(customerInfoResponse);
        ResponseEntity<CustomerInfoResponse> response = customerServiceImpl.getCustomers(id);
        assertEquals(ResponseEntity.ok(customerInfoResponse), response);


        // this will be failed because the customer object is not equal to the customerInfoResponse object
        // assertEquals(customerInfoResponse, customer);


        System.out.println("ID: " + id);
        System.out.println("Customer: " + customer);
        System.out.println("CustomerInfoResponse: " + customerInfoResponse);
        System.out.println("Response: " + response);

        verify(customerRepository).findById(id);
    }


    @Test
    void addCustomer() {

        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        addCustomerRequest.setNationalityId(123L);
        addCustomerRequest.setFirstName("Bob");
        addCustomerRequest.setMiddleName("Julian");
        addCustomerRequest.setLastName("Sponge");
        addCustomerRequest.setBirthDate(null);
        addCustomerRequest.setGender("sponge");
        addCustomerRequest.setFatherName("Mr.Sponge");
        addCustomerRequest.setMotherName("Mrs.Sponge");


        Customer customer = new Customer();
        customer.setNationalityId(123L);
        customer.setFirstName("Bob");
        customer.setMiddleName("Julian");
        customer.setLastName("Sponge");
        customer.setBirthDate(null);
        customer.setGender("sponge");
        customer.setFatherName("Mr.Sponge");
        customer.setMotherName("Mrs.Sponge");

        AddCustomerResponse expectedResponse = new AddCustomerResponse();
        expectedResponse.setNationalityId(123L);


        doNothing().when(customerBusinessRules).checkCustomerWithSameNationalityIdIsExist(anyLong());
        when(modelMapper.map(addCustomerRequest, Customer.class)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(modelMapper.map(customer, AddCustomerResponse.class)).thenReturn(expectedResponse);

        ResponseEntity<AddCustomerResponse> actualResponse = customerServiceImpl.addCustomer(addCustomerRequest);

        assertEquals(ResponseEntity.ok(expectedResponse), actualResponse);
        verify(customerBusinessRules).checkCustomerWithSameNationalityIdIsExist(addCustomerRequest.getNationalityId());
        verify(modelMapper).map(addCustomerRequest, Customer.class);
        verify(customerRepository).save(customer);
        verify(modelMapper).map(customer, AddCustomerResponse.class);
    }
}
