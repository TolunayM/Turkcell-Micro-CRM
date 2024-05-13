package com.TurkcellSRS.CustomerService.Config.Exception.CustomerException;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException() {
        super("Customer not found.");
    }
}
