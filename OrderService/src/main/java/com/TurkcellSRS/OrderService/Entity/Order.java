package com.TurkcellSRS.OrderService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long billingAccountId;
    @OneToOne
    private OrderAdress orderAdress;

    @OneToOne
    private Cart orderCart;
}
