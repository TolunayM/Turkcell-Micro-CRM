package com.TurkcellSRS.OrderService.Repository;


import com.TurkcellSRS.OrderService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
