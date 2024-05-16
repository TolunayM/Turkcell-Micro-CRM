package com.TurkcellSRS.CustomerService.Controller;

import com.TurkcellSRS.CustomerService.Product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testing")
@RequiredArgsConstructor
public class SomeController {


    private final ProductClient productClient;


    @GetMapping
    public String getSome() {
        return productClient.getSome();
    }
}
