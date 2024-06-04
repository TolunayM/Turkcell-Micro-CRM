package com.TurkcellSRS.OrderService.Logic.Service;


import com.TurkcellSRS.OrderService.Client.BillingAccountClient;
import com.TurkcellSRS.OrderService.Client.CartClient;
import com.TurkcellSRS.OrderService.Client.CustomerClient;
import com.TurkcellSRS.OrderService.Config.CartMapper;
import com.TurkcellSRS.OrderService.Config.OrderMapper;
import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Response.OrderResponse;
import com.TurkcellSRS.OrderService.Entity.Order;
import com.TurkcellSRS.OrderService.Logic.Contract.OrderService;
import com.TurkcellSRS.OrderService.Repository.OrderAddressRepository;
import com.TurkcellSRS.OrderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BillingAccountClient billingAccountClient;
    private final CustomerClient customerClient;
    private final CartClient cartClient;
    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;
    private final OrderAddressRepository orderAddressRepository;

    public ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest) {

        Order order = orderMapper.mapToEntity(orderRequest);
        var billingAccount = billingAccountClient.getBillingAccount(orderRequest.getBillingAccountId());
        var customer = customerClient.getCustomer(orderRequest.getCustomerId());
        var cart = cartClient.getCartByCustomerId(order.getCustomerId());
        var cartDao = cartMapper.toCart(cart);
        var orderAdress = customer.getDefaultAddress();
        orderAdress.setId(1L);
        orderAddressRepository.save(orderAdress);
        order.setOrderAdress(customer.getDefaultAddress());
        order.setOrderCart(cartDao);
        var savedOrder = orderRepository.save(order);

        return ResponseEntity.ok(orderMapper.mapToResponse(savedOrder));
        //address = billing account address
        //cart = billing account cart
    }

}
