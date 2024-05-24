package com.TurkcellSRS.CartService.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartCreateRequest {
    private Long customerId;
}
