package com.TurkcellSRS.CustomerService.Controller;

import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.AddAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.UpdateAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.UpdateAddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Logic.Contract.AddressService;
import com.TurkcellSRS.CustomerService.Logic.Services.AddressServiceImpl;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressServiceImpl addressService;


    @PostMapping
    public ResponseEntity<AddAddressResponse> addAddress(@Valid @RequestBody AddAddressRequest addAddressRequest) {
        return addressService.addAddress(addAddressRequest);
    }

    //TODO This can be transferred to customer controller
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<AddressResponse>> getAddressesByCustomerId(@PathVariable Long customerId) {
        return addressService.getAddressesByCustomerId(customerId);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAddress(@RequestParam("customer") Long customerId,@RequestParam("address") Long addressId) {
        return addressService.deleteAddress(customerId,addressId);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<UpdateAddressResponse> updateAddress(@PathVariable Long addressId, @Valid @RequestBody UpdateAddressRequest updateAddressRequest) {
        return addressService.updateAddress(addressId, updateAddressRequest);
    }

    @PostMapping("{customerId}/{addressId}")
    public ResponseEntity<AddressResponse> setDefaultAddress(@PathVariable Long customerId, @PathVariable Long addressId) {
        return addressService.setDefaultAddress(customerId, addressId);
    }
}
