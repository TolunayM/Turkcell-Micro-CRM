package com.TurkcellSRS.OrderService.DTO.Response;


import com.TurkcellSRS.OrderService.Entity.Cart;
import com.TurkcellSRS.OrderService.Entity.OrderAdress;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class OrderResponse {


//    private Long cartId;
    private Long customerId;
    private Long billingAccountId;
    private OrderAdress orderAdress;

    private Cart orderCart;
}
