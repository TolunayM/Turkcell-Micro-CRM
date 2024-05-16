package com.TurkcellSRS.CustomerService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);


	}



}
