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

    private final OrderServiceImpl orderService;


    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/checkOrder/{customerId}")
    public boolean checkOrderByCustomerId(@PathVariable Long customerId) {
        return orderService.checkOrderByCustomerId(customerId);
    }


    @PutMapping
    public String changeOrderStatus(@RequestParam Long orderId, @RequestParam String status){
        return orderService.changeOrderStatus(orderId, status);
    }
}
