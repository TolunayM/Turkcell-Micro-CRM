package com.TurkcellSRS.OrderService.Logic.Contract;

import com.TurkcellSRS.OrderService.DTO.ProductDTO;
import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Response.OrderResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest);
    boolean checkOrderByCustomerId(Long customerId);
    boolean checkOrderByBillingAccountId(Long billingAccountId);
    String changeOrderStatus(Long orderId, String status);
    ResponseEntity<List<ProductDTO>> getProductsByBillingAccountId(Long billingAccountId);
}
