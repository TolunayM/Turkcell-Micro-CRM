package com.TurkcellSRS.ProductService.Repository;


import com.TurkcellSRS.ProductService.DTO.Response.ProductResponse;
import com.TurkcellSRS.ProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c.id = :categoryId")
    List<Object> findAllByCategoryId(Long categoryId);


    @Query("SELECT new com.TurkcellSRS.ProductService.DTO.Response.SearchProductResponse(p.id, p.name, p.description , p.price) " +
            "FROM Product p " +
            "JOIN p.category c " +
            "WHERE (:id IS NULL or p.id = :id) " +
            "or (:categoryId IS NULL or c.id = :categoryId) " +
            "or (:name IS NULL or p.name LIKE %:name%)")
    List<ProductResponse> findByFilter(Long categoryId, Long id, String name);
}
