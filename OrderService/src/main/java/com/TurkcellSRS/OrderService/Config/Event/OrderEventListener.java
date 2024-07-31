package com.TurkcellSRS.OrderService.Config.Event;


import com.TurkcellSRS.OrderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {

    private final OrderRepository orderRepository;


    @KafkaListener(topics = "order-created", groupId = "order-group")
    public void handleOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("Order created event received: " + orderCreatedEvent);
        var order = orderRepository.findById(orderCreatedEvent.getOrderId());
        order.get().setStatus("CREATED_STATUS");
        orderRepository.save(order.get());
    }


    @KafkaListener(topics = "order-failed", groupId = "order-group")
    public void handleOrderFailedEvent(OrderFailedEvent orderFailedEvent) {
        System.out.println("Order failed event received: " + orderFailedEvent);
        var order = orderRepository.findById(orderFailedEvent.getOrderId());
        order.get().setStatus("FAILED_STATUS");
        orderRepository.save(order.get());
    }
}
