package com.TurkcellSRS.PricingService.Controller;


import com.TurkcellSRS.PricingService.DTO.CartProductsDTO;
import com.TurkcellSRS.PricingService.Logic.Contract.PriceService;
import com.TurkcellSRS.PricingService.Logic.Services.PriceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
@RequiredArgsConstructor
public class PriceController {


    private final PriceService priceService;


    @GetMapping("/{cartId}")
    public Double calculatePrice(@PathVariable Long cartId){
        return priceService.calculatePrice(cartId);
    }
}
