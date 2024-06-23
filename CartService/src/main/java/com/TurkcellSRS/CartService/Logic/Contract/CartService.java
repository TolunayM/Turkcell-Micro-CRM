package com.TurkcellSRS.CartService.Logic.Contract;

import com.TurkcellSRS.CartService.DTO.Response.CartCreateResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartProductsResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartResponse;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<CartCreateResponse> createCart(Long customerId);
    ResponseEntity<CartResponse> addItemToCart(Long cartId, Long productId, int quantity);
    Double totalPrice(Long cartId);
    ResponseEntity<CartProductsResponse> getCartProducts(Long cartId);
    ResponseEntity<CartResponse> getCartByCustomerId(Long customerId);
    ResponseEntity<String> deleteCart(Long cartId);
    ResponseEntity<CartResponse> deleteProductFromCart(Long cartId, Long productId);
}
