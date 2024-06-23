package com.TurkcellSRS.BillingAccountService.Config.Exception;

public class AccountHasOrderException extends RuntimeException{

    public AccountHasOrderException() {
        super("There are product/products connected to the billing account. You can not delete this account.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
