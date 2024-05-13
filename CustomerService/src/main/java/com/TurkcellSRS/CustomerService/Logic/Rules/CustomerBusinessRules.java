package com.TurkcellSRS.CustomerService.Logic.Rules;

import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerAlreadyExistException;
import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerNotFoundException;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerBusinessRules {

    private final CustomerRepository customerRepository;

    public void checkCustomerWithSameNationalityIdIsExist(Long nationalityId) {
        if (customerRepository.existByNationalityId(nationalityId) != null) {
            throw new CustomerAlreadyExistException();
        }
    }

    public void checkCustomerIsExist(Long nationalityId,Long id,String firstName,String middleName,String lastName){
        if (customerRepository.findByFilter(nationalityId, id, firstName, middleName, lastName).isEmpty()) {
            throw new CustomerNotFoundException();
        }
    }

    public void checkCustomerIsExist(Long id){
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException();
        }
    }
}
