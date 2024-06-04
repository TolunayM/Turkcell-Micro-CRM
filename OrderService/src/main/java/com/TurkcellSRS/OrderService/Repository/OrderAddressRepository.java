package com.TurkcellSRS.OrderService.Repository;

import com.TurkcellSRS.OrderService.Entity.OrderAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressRepository extends JpaRepository<OrderAdress, Long>{
}
