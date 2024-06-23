package com.TurkcellSRS.CartService.Logic.Services;


import com.TurkcellSRS.CartService.Client.PriceClient;
import com.TurkcellSRS.CartService.Client.ProductClient;
import com.TurkcellSRS.CartService.Client.ProductDTO;
import com.TurkcellSRS.CartService.DTO.Request.CartCreateRequest;
import com.TurkcellSRS.CartService.DTO.Response.CartCreateResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartProductsResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartResponse;
import com.TurkcellSRS.CartService.DTO.Response.CartWithChars;
import com.TurkcellSRS.CartService.Entity.Cart;
import com.TurkcellSRS.CartService.Logic.Contract.CartService;
import com.TurkcellSRS.CartService.Repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final PriceClient priceClient;

    public ResponseEntity<CartCreateResponse> createCart(Long customerId){
        CartCreateRequest cart = new CartCreateRequest(customerId);

        if(cartRepository.existsByCustomerId(customerId)){
            return ResponseEntity.badRequest().build();
        }

        cartRepository.save(modelMapper.map(cart, Cart.class));
        return ResponseEntity.ok(modelMapper.map(cart, CartCreateResponse.class));
    }

    public ResponseEntity<CartResponse> addItemToCart(Long cartId, Long productId,int quantity){

        //TODO Make adjustments for the cart and first check if product already exist in cart db if not then make service call
        var cart = cartRepository.findById(cartId);
        cart.get().getProductId().put(productId,quantity);
        // flush makes data goes brrr to db
        cartRepository.flush();
        cart.get().setTotalPrice(totalPrice(cartId));
        cartRepository.save(cart.get());
        return ResponseEntity.ok(modelMapper.map(cart, CartResponse.class));
    }


    public Double totalPrice(Long cartId){
        return priceClient.calculatePrice(cartId);
    }


    public ResponseEntity<CartProductsResponse> getCartProducts(Long cartId){
        var cart = cartRepository.findById(cartId);
        return ResponseEntity.ok(modelMapper.map(cart, CartProductsResponse.class));
    }

    public ResponseEntity<CartResponse> getCartByCustomerId(Long customerId) {
        var cart = cartRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(modelMapper.map(cart, CartResponse.class));
    }

    public ResponseEntity<String> deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
        return ResponseEntity.ok("Cart deleted");
    }

    public ResponseEntity<CartResponse> deleteProductFromCart(Long cartId, Long productId) {
        var cart = cartRepository.findById(cartId);
        cart.get().getProductId().remove(productId);
        cartRepository.save(cart.get());
        return ResponseEntity.ok(modelMapper.map(cart, CartResponse.class));
    }

    //TODO Implement update cart items characteristics like for example quantity and 100 gb internet so every item should have characteristics like GB or MB

}