package com.TurkcellSRS.CartService.Repository;

import com.TurkcellSRS.CartService.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<Cart,Long> {


    boolean existsByCustomerId(Long customerId);
    Cart findByCustomerId(Long customerId);
}
