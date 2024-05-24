package com.TurkcellSRS.CartService.Controller;


import com.TurkcellSRS.CartService.DTO.Response.CartCreateResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartResponse;
import com.TurkcellSRS.CartService.Logic.Services.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {


    private final CartServiceImpl cartService;



    @PostMapping("/{customerId}")
    public ResponseEntity<CartCreateResponse> createCart(@PathVariable Long customerId){
        return cartService.createCart(customerId);
    }

    @PostMapping("/{cartId}/product/{productId}")
    public ResponseEntity<CartResponse> addItemToCart(@PathVariable Long cartId,
                                                      @PathVariable Long productId,
                                                      @RequestParam int quantity){
        return cartService.addItemToCart(cartId, productId,quantity);
    }
}
