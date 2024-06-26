package com.TurkcellSRS.OrderService.Controller;


import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Response.OrderResponse;
import com.TurkcellSRS.OrderService.Logic.Contract.OrderService;
import com.TurkcellSRS.OrderService.Logic.Service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/checkOrder/{customerId}")
    public boolean checkOrderByCustomerId(@PathVariable Long customerId) {
        return orderService.checkOrderByCustomerId(customerId);
    }


    @GetMapping("/checkOrder/b/{billingAccountId}")
    public boolean checkOrderByBillingAccountId(@PathVariable Long billingAccountId) {
        return orderService.checkOrderByBillingAccountId(billingAccountId);
    }


    @PutMapping
    public String changeOrderStatus(@RequestParam Long orderId, @RequestParam String status){
        return orderService.changeOrderStatus(orderId, status);
    }

    @GetMapping("/products/{orderId}")
    public ResponseEntity<?> getProductsByOrderId(@PathVariable Long orderId){
        return orderService.getProductsByBillingAccountId(orderId);
    }
}
