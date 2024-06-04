package com.TurkcellSRS.OrderService.Config;

import com.TurkcellSRS.OrderService.DTO.CartDTO;
import com.TurkcellSRS.OrderService.Entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toCart(CartDTO cartDTO);
    CartDTO toCartDTO(Cart cart);
}
