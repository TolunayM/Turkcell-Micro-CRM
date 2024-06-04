package com.TurkcellSRS.OrderService.Config;


import com.TurkcellSRS.OrderService.DTO.Request.OrderRequest;
import com.TurkcellSRS.OrderService.DTO.Response.OrderResponse;
import com.TurkcellSRS.OrderService.Entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order mapToEntity(OrderRequest orderRequest);
    OrderResponse mapToResponse(Order order);
    OrderRequest mapToRequest(Order order);
}
