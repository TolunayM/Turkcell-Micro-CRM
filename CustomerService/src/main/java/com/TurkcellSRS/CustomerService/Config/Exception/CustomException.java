package com.TurkcellSRS.CustomerService.Config.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class CustomException {
    private int statusCode;
    private String message;

    public CustomException(int httpStatus, String message) {
        this.statusCode = httpStatus;
        this.message = message;
    }
}
