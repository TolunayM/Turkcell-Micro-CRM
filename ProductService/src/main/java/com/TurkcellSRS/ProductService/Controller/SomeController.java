package com.TurkcellSRS.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/some")
public class SomeController {

    @GetMapping("/data")
    public String getSome() {
        return "This is some data from ProductService.";
    }
}
