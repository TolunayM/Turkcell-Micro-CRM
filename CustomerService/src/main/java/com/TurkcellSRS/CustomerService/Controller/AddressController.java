package com.TurkcellSRS.CustomerService.Controller;

import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.AddAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Logic.Contract.AddressService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @PostMapping
    public ResponseEntity<AddAddressResponse> addAddress(@Valid @RequestBody AddAddressRequest addAddressRequest) {
        return addressService.addAddress(addAddressRequest);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<AddressResponse>> getAddressesByCustomerId(@PathVariable Long customerId) {
        return addressService.getAddressesByCustomerId(customerId);
    }
}
