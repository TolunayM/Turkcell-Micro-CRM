package com.TurkcellSRS.CustomerService.Config.Exception.CustomerException;

public class NationalityIdDigitsNotCorrectException extends RuntimeException{
    public NationalityIdDigitsNotCorrectException() {
        super("Nationality Id must be 11 digits.");
    }
}
