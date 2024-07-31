package com.TurkcellSRS.OrderService.Config.Event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFailedEvent {
    private Long orderId;
    private String message;
}
