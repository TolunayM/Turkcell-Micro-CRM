package com.TurkcellSRS.CustomerService.Config.Exception.AddressException;

public class OneAddressException extends RuntimeException {

    public OneAddressException() {
        super("Customer should have at least one address");
    }
}
