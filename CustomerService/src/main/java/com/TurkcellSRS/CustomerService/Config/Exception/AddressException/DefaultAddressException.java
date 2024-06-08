package com.TurkcellSRS.CustomerService.Config.Exception.AddressException;

public class DefaultAddressException extends RuntimeException{

    public DefaultAddressException() {
        super("The address that you want to delete is a default address. Please, change default address then try again");
    }

}
