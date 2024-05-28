package com.TurkcellSRS.PricingService.Logic.Services;


import com.TurkcellSRS.PricingService.Client.CartClient;
import com.TurkcellSRS.PricingService.Client.ProductClient;
import com.TurkcellSRS.PricingService.DTO.CartProductsDTO;
import com.TurkcellSRS.PricingService.DTO.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl {

    private final CartClient cartClient;
    private final ProductClient productClient;
    public Double calculatePrice(Long cartId) {

        //TODO make adjustments for the cart
        CartProductsDTO cartProducts = cartClient.getCartProducts(cartId);

        double totalPrice = 0.0;
        for (ProductDTO productId : cartProducts.getProducts()) {
            var product = productClient.getProductById(productId.getId());
            if(product != null && !product.getCharacteristics().keySet().isEmpty()){

                // TODO Check for each keys if its available in the product
                System.out.println("Product has characteristics");
                System.out.println(productClient.getProductById(productId.getId()).getCharacteristics().keySet());
                totalPrice += product.getCharacteristics().get("sms") * 10;
                totalPrice += product.getCharacteristics().get("call") * 20;
                totalPrice += product.getCharacteristics().get("internet") * 30;
                return totalPrice;
            }

            // second part of the code is quantity
            totalPrice += productClient.getProductById(productId.getId()).getPrice() * 2;
        }
        return totalPrice;
    }
}
