package com.TurkcellSRS.OrderService.Repository;


import com.TurkcellSRS.OrderService.DTO.Request.OrderStatusRequest;
import com.TurkcellSRS.OrderService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


    @Query("SELECT new com.TurkcellSRS.OrderService.DTO.Request.OrderStatusRequest(o.customerId, o.status) " +
            "FROM Order o WHERE o.customerId = :customerId")
    List<OrderStatusRequest> findAllByCustomerId(Long customerId);
}
