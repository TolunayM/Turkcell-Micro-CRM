package com.TurkcellSRS.CartService.Controller;


import com.TurkcellSRS.CartService.DTO.Response.CartCreateResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartProductsResponse;
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


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CartResponse> getCartByCustomerId(@PathVariable Long customerId){
        return cartService.getCartByCustomerId(customerId);
    }

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

    @GetMapping("/items/{cartId}")
    public ResponseEntity<CartProductsResponse> getCartProducts(@PathVariable Long cartId){
        return cartService.getCartProducts(cartId);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<String> deleteCart(@PathVariable Long cartId){
        return cartService.deleteCart(cartId);
    }


    @DeleteMapping("/{cartId}/product/{productId}")
    public ResponseEntity<CartResponse> deleteProductFromCart(@PathVariable Long cartId,
                                                              @PathVariable Long productId){
        return cartService.deleteProductFromCart(cartId,productId);
    }
}
