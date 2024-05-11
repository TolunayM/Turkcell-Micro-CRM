package com.TurkcellSRS.CustomerService.Repository;

import com.TurkcellSRS.CustomerService.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
