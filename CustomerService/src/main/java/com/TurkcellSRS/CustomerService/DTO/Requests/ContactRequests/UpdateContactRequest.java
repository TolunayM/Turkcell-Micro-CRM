package com.TurkcellSRS.CustomerService.DTO.Requests.ContactRequests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateContactRequest {

    @NotBlank(message = "This field is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "This field is required")
    @Digits(integer = 11, fraction = 0)
    @Positive
    private Long gsmNumber;

    @Digits(integer = 11, fraction = 0)
    @Positive
    private Long homeNumber;

    @Digits(integer = 12, fraction = 0)
    @Positive
    private Long fax;
}
