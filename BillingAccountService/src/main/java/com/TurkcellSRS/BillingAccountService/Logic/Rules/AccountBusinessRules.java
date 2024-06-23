package com.TurkcellSRS.BillingAccountService.Logic.Rules;

import com.TurkcellSRS.BillingAccountService.Client.OrderClient;
import com.TurkcellSRS.BillingAccountService.Config.Exception.AccountHasOrderException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountBusinessRules {

    private final OrderClient orderClient;


    public void checkAccountOrderIsExist(Long id){
        if(orderClient.checkOrderByBillingAccountId(id)){
            throw new AccountHasOrderException();
        }
}


}
