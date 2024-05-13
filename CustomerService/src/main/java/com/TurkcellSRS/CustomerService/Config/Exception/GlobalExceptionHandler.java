package com.TurkcellSRS.CustomerService.Config.Exception;


import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerAlreadyExistException;
import com.TurkcellSRS.CustomerService.Config.Exception.CustomerException.CustomerNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


// This happening in the persistence layer because of entity validation
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
//            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
//        }
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }




    // this happening in the controller layer because of dto validation

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        errors.put("statusCode", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(errors);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<CustomException> handleCustomerAlreadyExistException(CustomerAlreadyExistException ex) {
        // TODO can this be fabricated?
        CustomException customException = new CustomException(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customException);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<CustomException> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        CustomException customException = new CustomException(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customException);
    }


}
