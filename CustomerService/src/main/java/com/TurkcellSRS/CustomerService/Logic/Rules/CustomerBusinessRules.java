package com.TurkcellSRS.CustomerService.Logic.Rules;

import com.TurkcellSRS.CustomerService.Client.OrderClient;
import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerAlreadyExistException;
import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerHasOrderException;
import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerNotFoundException;
import com.TurkcellSRS.CustomerService.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerBusinessRules {

    private final CustomerRepository customerRepository;
    private final OrderClient orderClient;

    public void checkCustomerWithSameNationalityIdIsExist(Long nationalityId) {
        if (customerRepository.existByNationalityId(nationalityId) != null) {
            throw new CustomerAlreadyExistException();
        }
    }

    public void checkCustomerIsExist(Long nationalityId, Long id, String firstName, String middleName, String lastName, Pageable pageable){
        if (customerRepository.findByFilter(nationalityId, id, firstName, middleName, lastName,pageable).isEmpty()) {
            throw new CustomerNotFoundException();
        }
    }

    public void checkCustomerIsExist(Long id){
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException();
        }
    }


    public void checkCustomerOrderIsExist(Long id){
        if(orderClient.checkOrderByCustomerId(id)){
            throw new CustomerHasOrderException();
        }
    }
}