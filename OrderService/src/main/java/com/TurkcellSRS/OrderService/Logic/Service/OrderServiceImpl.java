package com.TurkcellSRS.OrderService.Logic.Service;


import com.TurkcellSRS.OrderService.Client.BillingAccountClient;
import com.TurkcellSRS.OrderService.Client.CartClient;
import com.TurkcellSRS.OrderService.Client.CustomerClient;
import com.TurkcellSRS.OrderService.Client.ProductClient;
import com.TurkcellSRS.OrderService.Config.CartMapper;
import com.TurkcellSRS.OrderService.Config.OrderMapper;
import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Response.OrderResponse;
import com.TurkcellSRS.OrderService.Entity.Cart;
import com.TurkcellSRS.OrderService.Entity.CartItem;
import com.TurkcellSRS.OrderService.Entity.Order;
import com.TurkcellSRS.OrderService.Logic.Contract.OrderService;
import com.TurkcellSRS.OrderService.Repository.CartItemRepository;
import com.TurkcellSRS.OrderService.Repository.CartRepository;
import com.TurkcellSRS.OrderService.Repository.OrderAddressRepository;
import com.TurkcellSRS.OrderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BillingAccountClient billingAccountClient;
    private final CustomerClient customerClient;
    private final CartClient cartClient;
    private final OrderAddressRepository orderAddressRepository;
    private final CartRepository cartRepository;
    private final ProductClient productClient;

    private final ModelMapper modelMapper;
    private final CartItemRepository cartItemRepository;

    public ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest) {

        Order order = modelMapper.map(orderRequest, Order.class);

        var billingAccount = billingAccountClient.getBillingAccount(orderRequest.getBillingAccountId());
        var customer = customerClient.getCustomer(orderRequest.getCustomerId());
        var cart = cartClient.getCartByCustomerId(orderRequest.getCustomerId());
        var cartDao = modelMapper.map(cart, Cart.class);
        System.out.println(
                "The cartDao is: " + cartDao + "\n" + "and the cart is " + cart
        );
        var orderAdress = customer.getDefaultAddress();
        orderAddressRepository.save(orderAdress);

//        for(Long entry : cart.getProductId().keySet()){
//            System.out.println("The product ID is: " + entry + " and price of that product is " + cart.getProductId().get(entry));
////            cartDao.getCartItems().add(modelMapper.map(cart.getProductId().get(entry), CartItem.class));
//            cartDao.setCartItems(cart.getProductId().keySet().stream().map(
//                    key -> {
//                        CartItem cartItem = new CartItem();
//                        cartItem.setId(key);
//                        cartItem.setPrice(1000.0);
//                        return cartItem;
//                    }
//            ).collect(Collectors.toSet()));
//
//        }


        for(Long productId : cart.getProductId().keySet()){
            var product = productClient.getProductById(productId);
            System.out.println(product);
            if(product != null){
                CartItem cartItem = new CartItem();
                cartItem.setId(productId);
                cartItem.setPrice(product.getPrice());
                cartItemRepository.save(cartItem);
                cartDao.getCartItems().add(cartItem);
            }
        }
        cartRepository.save(cartDao);


        cartRepository.save(cartDao);
        order.setOrderAdress(customer.getDefaultAddress());
        order.setOrderCart(cartDao);
        System.out.println(order);
        var savedOrder = orderRepository.save(order);
        System.out.println(savedOrder);

        return ResponseEntity.ok(modelMapper.map(savedOrder, OrderResponse.class));
        //address = billing account address
        //cart = billing account cart
    }

}
