package com.TurkcellSRS.CustomerService.Config.Exception.CustomerException;

public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException() {
        //TODO change this message because it is not safe to telling "we have this id in the system."
        super("This nationality ID already exists in the system.");
    }
}
