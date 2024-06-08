package com.TurkcellSRS.CustomerService.Controller;

import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.AddCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.CustomerRequests.UpdateCustomerRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.AddCustomerResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.CustomerInfoResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.SearchCustomerResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.CustomerResponse.UpdateCustomerResponse;
import com.TurkcellSRS.CustomerService.Logic.Services.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;


@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    private final int MAX_PAGE_SIZE = 10;


    @GetMapping("/search")
    public ResponseEntity<List<SearchCustomerResponse>> searchCustomerByVariables(@RequestParam(required = false, defaultValue = " ") Long nationalityId,
                                                                                  @RequestParam(required = false, defaultValue = " ") Long id,
                                                                                  @RequestParam(required = false, defaultValue = " ") String firstName,
                                                                                  @RequestParam(required = false, defaultValue =  " ") String middleName,
                                                                                  @RequestParam(required = false, defaultValue = " ") String lastName,
                                                                                  @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, MAX_PAGE_SIZE);
        return customerService.searchByVariables(nationalityId, id, firstName, middleName, lastName, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoResponse> getCustomer(@PathVariable Long id){
        return customerService.getCustomers(id);
    }




    @PostMapping
    public ResponseEntity<AddCustomerResponse> addCustomer(@Valid @RequestBody  AddCustomerRequest addCustomerRequest){
        return customerService.addCustomer(addCustomerRequest);
}
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateCustomerResponse> updateCustomer(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){
        return customerService.updateCustomer(updateCustomerRequest);
    }
}
