package com.TurkcellSRS.BillingAccountService.Logic.Contract;

import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountRequest;
import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillingAccountService {

    ResponseEntity<BillingAccountResponse> getBillingAccount(Long id);
    ResponseEntity<List<BillingAccountResponse>> getBillingAccountByCustomer(Long id , Pageable pageable);
    ResponseEntity<BillingAccountResponse> createBillingAccount(BillingAccountRequest billingAccountRequest);
    ResponseEntity<String> deleteBillingAccount(Long id);

}
