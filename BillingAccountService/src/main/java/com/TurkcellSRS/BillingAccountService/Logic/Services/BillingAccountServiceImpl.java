package com.TurkcellSRS.BillingAccountService.Logic.Services;

import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountRequest;
import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountResponse;
import com.TurkcellSRS.BillingAccountService.Entity.BillingAccount;
import com.TurkcellSRS.BillingAccountService.Logic.Contract.BillingAccountService;
import com.TurkcellSRS.BillingAccountService.Logic.Rules.AccountBusinessRules;
import com.TurkcellSRS.BillingAccountService.Repository.BillingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillingAccountServiceImpl implements BillingAccountService {

    private final BillingAccountRepository billingAccountRepository;
    private final ModelMapper modelMapper;
    private final AccountBusinessRules accountBusinessRules;

    //on frontend there will be a page for default billing account


    public ResponseEntity<BillingAccountResponse> getBillingAccount(Long id) {
        var billingAccount = billingAccountRepository.findById(id);


        return ResponseEntity.ok(modelMapper.map(billingAccount, BillingAccountResponse.class));
    }


    public ResponseEntity<List<BillingAccountResponse>> getBillingAccountByCustomer(Long id , Pageable pageable) {
        List<BillingAccountResponse> customerBillingAccounts = new LinkedList<>();
        var billingAccount = billingAccountRepository.findAllByCustomer(id,pageable);
        billingAccount.forEach(account -> {
            customerBillingAccounts.add(modelMapper.map(account, BillingAccountResponse.class));
        });
        return ResponseEntity.ok(customerBillingAccounts);

    }

    public ResponseEntity<BillingAccountResponse> createBillingAccount(BillingAccountRequest billingAccountRequest) {
        var billingAccount = modelMapper.map(billingAccountRequest, BillingAccount.class);
        billingAccount.setName(String.valueOf(billingAccountRequest.getAccountNumber()));
        billingAccount = billingAccountRepository.save(billingAccount);

        return ResponseEntity.ok(modelMapper.map(billingAccount, BillingAccountResponse.class));
    }


    public ResponseEntity<String> deleteBillingAccount(Long id) {
        accountBusinessRules.checkAccountOrderIsExist(id);
        billingAccountRepository.deleteById(id);
        return ResponseEntity.ok("Customer account deleted successfully");
    }
}
