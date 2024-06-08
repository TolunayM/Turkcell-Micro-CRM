package com.TurkcellSRS.CustomerService.Config.Exception.CustomerException;

import jdk.jfr.StackTrace;

public class CustomerHasOrderException extends RuntimeException{

    public CustomerHasOrderException() {
        super("Customer has an active order. You can not delete this customer.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
