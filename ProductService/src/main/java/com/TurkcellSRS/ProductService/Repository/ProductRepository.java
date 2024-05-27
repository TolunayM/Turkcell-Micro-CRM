package com.TurkcellSRS.ProductService.Repository;


import com.TurkcellSRS.ProductService.Entity.Product;
import com.TurkcellSRS.ProductService.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE TYPE(p) = Subscription")
    List<Subscription> findSubscriptions();
}
