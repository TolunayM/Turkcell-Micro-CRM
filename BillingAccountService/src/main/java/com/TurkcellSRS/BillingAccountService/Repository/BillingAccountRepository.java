package com.TurkcellSRS.BillingAccountService.Repository;


import com.TurkcellSRS.BillingAccountService.DTO.BillingAccountResponse;
import com.TurkcellSRS.BillingAccountService.Entity.BillingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingAccountRepository extends JpaRepository<BillingAccount, Long>{
    List<BillingAccount> findAllByCustomer(Long id);
}
