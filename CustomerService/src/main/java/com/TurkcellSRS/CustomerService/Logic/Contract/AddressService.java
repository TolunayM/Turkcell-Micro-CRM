package com.TurkcellSRS.CustomerService.Logic.Contract;

import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.AddAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.UpdateAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.DeleteAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.UpdateAddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    ResponseEntity<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);
    ResponseEntity<UpdateAddressResponse> updateAddress(Long addressId,UpdateAddressRequest updateAddressRequest);
    ResponseEntity<String> deleteAddress(Long custoemerId, Long addressId);
    ResponseEntity<AddressResponse> getAddress(Long addressId);
    ResponseEntity<List<AddressResponse>> getAddressesByCustomerId(Long customerId);
    ResponseEntity<AddressResponse> setDefaultAddress(Long customerId, Long addressId);
}
