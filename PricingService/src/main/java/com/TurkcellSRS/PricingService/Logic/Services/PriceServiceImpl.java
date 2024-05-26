package com.TurkcellSRS.PricingService.Logic.Services;


import com.TurkcellSRS.PricingService.Client.CartClient;
import com.TurkcellSRS.PricingService.Client.ProductClient;
import com.TurkcellSRS.PricingService.DTO.CartProductsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl {

    private final CartClient cartClient;
    private final ProductClient productClient;
    public Double calculatePrice(Long cartId) {

        //TODO make adjustments for the cart and first check if products charachteristics
        CartProductsDTO cartProducts = cartClient.getCartProducts(cartId);
        double totalPrice = 0.0;
        for (Long productId : cartProducts.getProductId().keySet()) {
            totalPrice += productClient.getProductById(productId).getPrice() * cartProducts.getProductId().get(productId);
        }
        return totalPrice;
    }
}
