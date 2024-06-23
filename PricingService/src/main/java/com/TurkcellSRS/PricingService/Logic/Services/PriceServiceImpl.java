package com.TurkcellSRS.PricingService.Logic.Services;


import com.TurkcellSRS.PricingService.Client.CartClient;
import com.TurkcellSRS.PricingService.Client.ProductClient;
import com.TurkcellSRS.PricingService.DTO.CartProductsDTO;
import com.TurkcellSRS.PricingService.Logic.Contract.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final CartClient cartClient;
    private final ProductClient productClient;
    public Double calculatePrice(Long cartId) {

        //TODO make adjustments for the cart
        CartProductsDTO cartProducts = cartClient.getCartProducts(cartId);

        double totalPrice = 0.0;
        for (Long productId : cartProducts.getProductId().keySet()) {
            var product = productClient.getProductById(productId);
            if(product != null && !product.getCharacteristics().keySet().isEmpty()){

                // TODO Check for each keys if its available in the product
                System.out.println("Product has characteristics");
                System.out.println(productClient.getProductById(productId).getCharacteristics().keySet());
                totalPrice += product.getCharacteristics().get("sms") * 10;
                totalPrice += product.getCharacteristics().get("dakika") * 20;
                totalPrice += product.getCharacteristics().get("internet") * 30;
                return totalPrice;
            }

            // second part of the code is quantity
            totalPrice += productClient.getProductById(productId).getPrice() * cartProducts.getProductId().get(productId);
        }
        return totalPrice;
    }
}
