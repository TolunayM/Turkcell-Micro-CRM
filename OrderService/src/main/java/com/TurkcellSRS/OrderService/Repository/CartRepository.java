package com.TurkcellSRS.OrderService.Repository;


import com.TurkcellSRS.OrderService.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
}
