package com.TurkcellSRS.BillingAccountService.Controller;


import com.TurkcellSRS.BillingAccountService.Client.CustomerClient;
import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountRequest;
import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountResponse;
import com.TurkcellSRS.BillingAccountService.Logic.Services.BillingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class BillingAccountController {

    private final BillingAccountService billingAccountService;
    private final CustomerClient customerClient;

    @GetMapping("/{id}")
    public ResponseEntity<BillingAccountResponse> getBillingAccount(@PathVariable Long id) {
        return billingAccountService.getBillingAccount(id);
    }



    @PostMapping
    public ResponseEntity<BillingAccountResponse> createBillingAccount(@RequestBody BillingAccountRequest billingAccountRequest) {
        return billingAccountService.createBillingAccount(billingAccountRequest);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<BillingAccountResponse>> getBillingAccountByCustomer(@PathVariable Long id) {
        return billingAccountService.getBillingAccountByCustomer(id);
    }
}
