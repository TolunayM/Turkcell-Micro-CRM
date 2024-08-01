package com.TurkcellSRS.OrderService.Logic.Service;


import com.TurkcellSRS.OrderService.Client.BillingAccountClient;
import com.TurkcellSRS.OrderService.Client.CartClient;
import com.TurkcellSRS.OrderService.Client.CustomerClient;
import com.TurkcellSRS.OrderService.Client.ProductClient;
import com.TurkcellSRS.OrderService.Config.CartMapper;
import com.TurkcellSRS.OrderService.Config.Event.OrderCreatedEvent;
import com.TurkcellSRS.OrderService.Config.Event.OrderFailedEvent;
import com.TurkcellSRS.OrderService.Config.OrderMapper;
import com.TurkcellSRS.OrderService.DTO.ProductDTO;
import com.TurkcellSRS.OrderService.DTO.Request.OrderBillingRequest;
import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Request.OrderStatusRequest;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final CartClient cartClient;
    private final OrderAddressRepository orderAddressRepository;
    private final CartRepository cartRepository;
    private final ProductClient productClient;

    private final ModelMapper modelMapper;
    private final CartItemRepository cartItemRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ResponseEntity<OrderResponse> createOrder(OrderRequest orderRequest) {

        Order order = modelMapper.map(orderRequest, Order.class);

        try {
            var customer = customerClient.getCustomer(orderRequest.getCustomerId());
            var cart = cartClient.getCartByCustomerId(orderRequest.getCustomerId());
            var cartDao = modelMapper.map(cart, Cart.class);
            System.out.println(
                    "The cartDao is: " + cartDao + "\n" + "and the cart is " + cart
            );
            var orderAdress = customer.getDefaultAddress();
            orderAddressRepository.save(orderAdress);



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
            order.setOrderAdress(customer.getDefaultAddress());
            order.setOrderCart(cartDao);
            System.out.println(order);
            order.setStatus("ACTIVE");
            var savedOrder = orderRepository.save(order);
            System.out.println(savedOrder);
            kafkaTemplate.send("order-created", new OrderCreatedEvent(savedOrder.getId(), orderRequest.getCustomerId(),orderRequest.getBillingAccountId()));
            return ResponseEntity.ok(modelMapper.map(savedOrder, OrderResponse.class));
        } catch (Exception e) {
            kafkaTemplate.send("order-failed", new OrderFailedEvent(order.getId(), "Failed"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public boolean checkOrderByCustomerId(Long customerId) {

        //find by status active
        boolean status = false;
        List<OrderStatusRequest> orders = orderRepository.findAllByCustomerId(customerId);

        for(OrderStatusRequest order : orders){
            if(order.getStatus().equals("ACTIVE")){
                status = true;
                break;
            }
        }
        return status;
    }

    public boolean checkOrderByBillingAccountId(Long billingAccountId) {

        //find by status active
        boolean status = false;
        List<OrderBillingRequest> orders = orderRepository.findAllByBillingAccountId(billingAccountId);

        for(OrderBillingRequest order : orders){
            if(order.getStatus().equals("ACTIVE")){
                status = true;
                break;
            }
        }
        return status;
    }

    public String changeOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);
        return "Order " + orderId + " status changed to " + status;
    }

    public ResponseEntity<List<ProductDTO>> getProductsByBillingAccountId(Long billingAccountId) {
        Order order = orderRepository.findByBillingAccountId(billingAccountId);
        Cart cart = order.getOrderCart();
        List<Long> productIds = cart.getCartItems().stream().map(CartItem::getId).toList();
        List<ProductDTO> products = productIds.stream()
                .map(productClient::getProductById)
                .toList();

        return ResponseEntity.ok(products);

    }
}
