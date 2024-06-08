package com.TurkcellSRS.CustomerService.Logic.Rules;

import com.TurkcellSRS.CustomerService.Config.Exception.AddressException.DefaultAddressException;
import com.TurkcellSRS.CustomerService.Config.Exception.AddressException.OneAddressException;
import com.TurkcellSRS.CustomerService.Repository.AddressRepository;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressBusinessRules {

    private final CustomerRepository customerRepository;

    public void checkIsAddressLast(Long customerId) {
        if (customerRepository.findById(customerId).get().getAddresses().stream().count() == 1) {
            throw new OneAddressException();
        }
    }


    public void checkIsDefaultAddress(Long customerId, Long addressId) {
        if (customerRepository.findById(customerId).get().getDefaultAddress().getId() == addressId) {
            throw new DefaultAddressException();
        }
    }

}
