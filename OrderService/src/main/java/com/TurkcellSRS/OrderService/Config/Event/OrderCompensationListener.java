package com.TurkcellSRS.OrderService.Config.Event;


import com.TurkcellSRS.OrderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCompensationListener {

    private final OrderRepository orderRepository;

    @KafkaListener(topics = "order-failed", groupId = "order-group")
    public void handleOrderFailedEvent(OrderFailedEvent orderFailedEvent) {
        System.out.println("Order compensation event received: " + orderFailedEvent);
        // some logic for compensation
    }
}
