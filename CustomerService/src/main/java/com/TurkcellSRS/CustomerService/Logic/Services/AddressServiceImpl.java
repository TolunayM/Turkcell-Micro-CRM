package com.TurkcellSRS.CustomerService.Logic.Services;

import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.AddAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Requests.AddressRequests.UpdateAddressRequest;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.DeleteAddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.AddressResponse;
import com.TurkcellSRS.CustomerService.DTO.Response.AddressResponse.UpdateAddressResponse;
import com.TurkcellSRS.CustomerService.Entity.Address;
import com.TurkcellSRS.CustomerService.Entity.Customer;
import com.TurkcellSRS.CustomerService.Logic.Contract.AddressService;
import com.TurkcellSRS.CustomerService.Repository.AddressRepository;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;

    @Override
    public ResponseEntity<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {
        var saveAddress = modelMapper.map(addAddressRequest, Address.class);

        // Find the Customer by its ID
        //TODO Change this to business rule
        //TODO Change this to customerDTO
        Customer customer = customerRepository.findById(addAddressRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + addAddressRequest.getCustomerId()));

        // Set the Customer to the Address
        saveAddress.setCustomer(customer);

        var savedAddress = addressRepository.save(saveAddress);
        return ResponseEntity.ok(modelMapper.map(savedAddress, AddAddressResponse.class));
    }

    @Override
    public ResponseEntity<UpdateAddressResponse> updateAddress(UpdateAddressRequest updateAddressRequest) {
        return null;
    }

    @Override
    public ResponseEntity<DeleteAddressResponse> deleteAddress(Long addressId) {
        return null;
    }

    @Override
    public ResponseEntity<AddressResponse> getAddress(Long addressId) {
        return null;
    }

    public ResponseEntity<List<AddressResponse>> getAddressesByCustomerId(Long customerId) {
        return ResponseEntity.ok(addressRepository.findAllByCustomerId(customerId));
    }
}
