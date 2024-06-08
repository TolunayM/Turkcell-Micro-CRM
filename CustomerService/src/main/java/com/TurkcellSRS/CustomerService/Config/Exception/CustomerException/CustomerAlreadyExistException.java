package com.TurkcellSRS.CustomerService.Config.Exception.CustomerException;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException() {
        super("Customer already exists in the system.");
    }
}
